package com.zhixue.learning.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhixue.base.exception.XueChengPlusException;
import com.zhixue.base.model.RestResponse;
import com.zhixue.content.model.dto.TeachplanDto;
import com.zhixue.content.model.po.CoursePublish;
import com.zhixue.learning.feignclient.ContentServiceClient;
import com.zhixue.learning.feignclient.MediaServiceClient;
import com.zhixue.learning.model.dto.XcCourseTablesDto;
import com.zhixue.learning.service.LearningService;
import com.zhixue.learning.service.MyCourseTablesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学习课程管理 service 接口实现类
 */
@Service
public class LearningServiceImpl implements LearningService {

    @Autowired
    private ContentServiceClient contentServiceClient;

    @Autowired
    private MediaServiceClient mediaServiceClient;

    @Autowired
    private MyCourseTablesService myCourseTablesService;


    @Override
    public RestResponse<String> getVideo(String userId, Long courseId, Long teachplanId, String mediaId) {
        // 查询课程信息
        CoursePublish coursePublish = contentServiceClient.getCoursePublish(courseId);
        if (coursePublish == null) {
            XueChengPlusException.cast("课程信息不存在");
        }
        // 校验学习资格
        // 判断是否是试学课程
        List<TeachplanDto> teachplans = JSON.parseArray(coursePublish.getTeachplan(), TeachplanDto.class);
        // 如果是试学视频直接返回视频地址
        if (isTeachplanPreview(teachplanId, teachplans)) {
            return mediaServiceClient.getPlayUrlByMediaId(mediaId);
        }

        // 如果登录
        if (StringUtils.isNotEmpty(userId)) {
            // 判断是否选课，根据选课情况判断学习资格
            XcCourseTablesDto courseTablesDto = myCourseTablesService.getLearningStatus(userId, courseId);
            String learnStatus = courseTablesDto.getLearnStatus();
            if ("702001".equals(learnStatus)) {
                // 正常学习
                return mediaServiceClient.getPlayUrlByMediaId(mediaId);
            } else if ("702003".equals(learnStatus)) {
                RestResponse.validfail("您选的课程已过期，需要申请续期或重新支付");
            }
        }

        // 未登录或选课判断是否收费
        String charge = coursePublish.getCharge();
        if ("201000".equals(charge)) {
            // 免费课程
            return mediaServiceClient.getPlayUrlByMediaId(mediaId);
        }
        return RestResponse.validfail("请购买课程后继续学习");
    }

    /**
     * 判断是否是试学课程
     *
     * @param teachplanId 教学计划id
     * @param teachplans  教学计划列表
     * @return 试学课程返回 true，否则返回 false
     */
    private boolean isTeachplanPreview(Long teachplanId, List<TeachplanDto> teachplans) {
        for (TeachplanDto first : teachplans) {
            if (first.getTeachPlanTreeNodes() != null) {
                for (TeachplanDto second : first.getTeachPlanTreeNodes()) {
                    if (second.getId().equals(teachplanId) && "1".equals(second.getIsPreview())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
