package com.zhixue.content.api;

import com.zhixue.content.model.dto.CoursePreviewDto;
import com.zhixue.content.service.CourseBaseInfoService;
import com.zhixue.content.service.CoursePublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程公开查询接口
 */
@Api(value = "课程公开查询接口", tags = "课程公开查询接口")
@RestController
@RequestMapping("/open")
public class CourseOpenController {
    @Autowired
    private CourseBaseInfoService courseBaseInfoService;

    @Autowired
    private CoursePublishService coursePublishService;


    @ApiOperation("获取课程预览信息")
    @GetMapping("/course/whole/{courseId}")
    public CoursePreviewDto getPreviewInfo(@PathVariable("courseId") Long courseId) {
        return coursePublishService.getOpenCoursePreviewInfo(courseId);
    }
}
