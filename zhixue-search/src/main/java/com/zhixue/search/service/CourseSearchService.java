package com.zhixue.search.service;

import com.zhixue.base.model.PageParams;
import com.zhixue.search.dto.SearchCourseParamDto;
import com.zhixue.search.dto.SearchPageResultDto;
import com.zhixue.search.po.CourseIndex;

/**
 * 课程搜索service
 */
public interface CourseSearchService {


    /**
     * 搜索课程列表
     *
     * @param pageParams           分页参数
     * @param searchCourseParamDto 搜索条件
     * @return {@link com.zhixue.base.model.PageResult}<{@link com.zhixue.search.po.CourseIndex}> 课程列表
     * @author Wuxy
     * @since 2022/9/24 22:45
     */
    SearchPageResultDto<CourseIndex> queryCoursePubIndex(PageParams pageParams, SearchCourseParamDto searchCourseParamDto);

}
