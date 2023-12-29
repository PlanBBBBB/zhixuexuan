package com.zhixue.learning.api;

import com.zhixue.base.exception.XueChengPlusException;
import com.zhixue.base.model.PageResult;
import com.zhixue.learning.model.dto.MyCourseTableItemDto;
import com.zhixue.learning.model.dto.MyCourseTableParams;
import com.zhixue.learning.model.dto.XcChooseCourseDto;
import com.zhixue.learning.model.dto.XcCourseTablesDto;
import com.zhixue.learning.service.MyCourseTablesService;
import com.zhixue.learning.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的课程表接口
 */
@Api(value = "我的课程表接口", tags = "我的课程表接口")
@Slf4j
@RestController
public class MyCourseTableController {

    @Autowired
    private MyCourseTablesService myCourseTablesService;


    @ApiOperation("添加选课")
    @PostMapping("/choosecourse/{courseId}")
    public XcChooseCourseDto addChooseCourse(@PathVariable("courseId") Long courseId) {
        // 当前登录用户
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if (user == null) {
            XueChengPlusException.cast("请登陆后继续选课");
        }
        String userId = user.getId();
        return myCourseTablesService.addChooseCourse(userId, courseId);
    }

    @ApiOperation("查询学习资格")
    @PostMapping("/choosecourse/learnstatus/{courseId}")
    public XcCourseTablesDto getLearnStatus(@PathVariable("courseId") Long courseId) {
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if (user == null) {
            XueChengPlusException.cast("请登陆后查询学习资格");
        }
        return myCourseTablesService.getLearningStatus(user.getId(), courseId);
    }

    @ApiOperation("我的课程表")
    @GetMapping("/mycoursetable")
    public PageResult<MyCourseTableItemDto> myCourseTable(MyCourseTableParams params) {
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if (user == null) {
            XueChengPlusException.cast("请登陆后继续选课");
        }
        params.setUserId(user.getId());
        return myCourseTablesService.myCourseTables(params);
    }
}
