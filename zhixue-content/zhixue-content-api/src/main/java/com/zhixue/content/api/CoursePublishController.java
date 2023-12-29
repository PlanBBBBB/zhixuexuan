package com.zhixue.content.api;

import com.zhixue.content.model.dto.CoursePreviewDto;
import com.zhixue.content.model.po.CoursePublish;
import com.zhixue.content.service.CoursePublishService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 课程预览，发布
 */
@Controller
public class CoursePublishController {

    @Autowired
    private CoursePublishService coursePublishService;

    @ApiOperation("课程预览")
    @GetMapping("/coursepreview/{courseId}")
    public ModelAndView preview(@PathVariable("courseId") Long courseId) {
        ModelAndView modelAndView = new ModelAndView();
        // 获取课程预览信息
        CoursePreviewDto coursePreviewInfo = coursePublishService.getCoursePreviewInfo(courseId);
        modelAndView.addObject("model", coursePreviewInfo);
        modelAndView.setViewName("course_template");
        return modelAndView;
    }

    @ApiOperation("提交课程审核")
    @ResponseBody
    @PostMapping("/courseaudit/commit/{courseId}")
    public void commitAudit(@PathVariable("courseId") Long courseId) {
        Long companyId = 1232141425L;
        coursePublishService.commitAudit(companyId, courseId);
    }

    @ApiOperation("查询课程发布信息")
    @GetMapping("/r/coursepublish/{courseId}")
    @ResponseBody
    public CoursePublish getCoursePublish(@PathVariable("courseId") Long courseId) {
        return coursePublishService.getCoursePublishCache(courseId);
    }

    @ApiOperation("课程发布")
    @ResponseBody
    @PostMapping("/coursepublish/{courseId}")
    public void coursePublish(@PathVariable("courseId") Long courseId) {
        Long companyId = 1232141425L;
        coursePublishService.publish(companyId, courseId);
    }

    @ApiOperation("查询课程预览信息")
    @ResponseBody
    @GetMapping("/course/whole/{courseId}")
    public CoursePreviewDto getPreviewInfo(@PathVariable("courseId") Long courseId) {
        return coursePublishService.getCoursePreviewInfo(courseId);
    }

}
