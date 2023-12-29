package com.zhixue.learning.api;

import com.zhixue.base.exception.XueChengPlusException;
import com.zhixue.base.model.RestResponse;
import com.zhixue.learning.service.LearningService;
import com.zhixue.learning.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "学习课程管理接口", tags = "学习课程管理接口")
@RestController
public class MyLearningController {

    @Autowired
    private LearningService learningService;


    @ApiOperation("获取视频")
    @GetMapping("/open/learn/getvideo/{courseId}/{teachplanId}/{mediaId}")
    public RestResponse<String> getVideo(@PathVariable("courseId") Long courseId,
                                         @PathVariable("teachplanId") Long teachplanId,
                                         @PathVariable("mediaId") String mediaId) {
        // 登录用户
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if (user == null) {
            XueChengPlusException.cast("请登陆后学习课程视频");
        }
        // 获取视频
        return learningService.getVideo(user.getId(), courseId, teachplanId, mediaId);
    }
}
