package com.zhixue.content.api;

import com.zhixue.base.exception.ValidationGroups;
import com.zhixue.base.model.PageParams;
import com.zhixue.base.model.PageResult;
import com.zhixue.base.model.RestResponse;
import com.zhixue.content.model.dto.AddCourseDto;
import com.zhixue.content.model.dto.CourseBaseInfoDto;
import com.zhixue.content.model.dto.EditCourseDto;
import com.zhixue.content.model.dto.QueryCourseParamsDto;
import com.zhixue.content.model.po.CourseBase;
import com.zhixue.content.service.CourseBaseInfoService;
import com.zhixue.content.util.SecurityUtil;
import com.zhixue.content.util.SecurityUtil.XcUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程信息编辑接口
 */
@Api(value = "课程信息编辑接口", tags = "课程信息编辑接口")
@RestController
@RequestMapping("/course")
public class CourseBaseInfoController {

    @Resource
    private CourseBaseInfoService courseBaseInfoService;


    @ApiOperation("课程查询接口")
    @PostMapping("/list")
    @PreAuthorize("hasAuthority('xc_teachmanager_course_list')") // 拥有课程列表查询的授权方可访问（jwt中保存了UserDetails信息）
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto queryCourseParams) {
        // 取出身份
        XcUser user = SecurityUtil.getUser();
        // 得到机构id
        assert user != null;
        Long companyId = user.getCompanyId();
        // 调用 service 获取数据 （实现细粒度授权，本机构只能查询自己机构的课程列表）
        return courseBaseInfoService.queryCourseBaseList(companyId, pageParams, queryCourseParams);
    }

    @ApiOperation("新增课程")
    @PostMapping("")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated(ValidationGroups.Insert.class) AddCourseDto addCourseDto) {

        // 获取当前用户所属的培训机构 id
        Long companyId = 1232141425L;
        // 调用 service
        return courseBaseInfoService.createCourseBase(companyId, addCourseDto);
    }

    @ApiOperation("根据课程id查询课程基础信息")
    @GetMapping("/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable("courseId") Long courseId) {
        // 取出当前用户身份
        XcUser user = SecurityUtil.getUser();
        return courseBaseInfoService.queryCourseBaseById(courseId);
    }

    @ApiOperation("修改课程信息")
    @PutMapping("")
    public CourseBaseInfoDto modifyCourseBase(@RequestBody EditCourseDto dto) {
        Long companyId = 1232141425L;
        return courseBaseInfoService.updateCourseBase(companyId, dto);
    }

    @ApiOperation("删除课程")
    @DeleteMapping("/{courseId}")
    public RestResponse<Boolean> deleteCourseBase(@PathVariable Long courseId) {

        return courseBaseInfoService.deleteCourseBase(courseId);
    }

}
