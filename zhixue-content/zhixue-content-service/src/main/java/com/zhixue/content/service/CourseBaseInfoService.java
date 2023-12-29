package com.zhixue.content.service;

import com.zhixue.base.model.PageParams;
import com.zhixue.base.model.PageResult;
import com.zhixue.base.model.RestResponse;
import com.zhixue.content.model.dto.AddCourseDto;
import com.zhixue.content.model.dto.CourseBaseInfoDto;
import com.zhixue.content.model.dto.EditCourseDto;
import com.zhixue.content.model.dto.QueryCourseParamsDto;
import com.zhixue.content.model.po.CourseBase;

/**
 * 课程管理 Service
 */
public interface CourseBaseInfoService {

    /**
     * 课程查询
     *
     * @param companyId         机构id
     * @param params            分页参数
     * @param queryCourseParams 查询条件
     * @return 分页结果
     */
    PageResult<CourseBase> queryCourseBaseList(Long companyId, PageParams params, QueryCourseParamsDto queryCourseParams);

    /**
     * 新增课程
     *
     * @param companyId    培训机构 id
     * @param addCourseDto 新增课程的信息
     * @return 课程信息包括基本信息，营销信息
     */
    CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);

    /**
     * 根据课程id查询课程基本信息，包括基本信息和营销信息
     *
     * @param courseId 课程id
     * @return 返回对应的课程信息
     */
    CourseBaseInfoDto queryCourseBaseById(Long courseId);

    /**
     * 修改课程信息
     *
     * @param companyId 机构id（校验：本机构只能修改本机构的课程）
     * @param dto       课程信息
     * @return 返回修改后的课程信息
     */
    CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto dto);

    /**
     * 删除课程
     *
     * @param courseId 课程 id
     * @return 删除结果
     */
    RestResponse<Boolean> deleteCourseBase(Long courseId);

}
