package com.zhixue;

import com.zhixue.base.model.PageParams;
import com.zhixue.content.mapper.CourseBaseMapper;
import com.zhixue.content.model.dto.QueryCourseParamsDto;
import com.zhixue.content.service.CourseBaseInfoService;
import com.zhixue.content.service.CourseCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ContentServiceApplicationTests {

    @Resource
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private CourseBaseInfoService courseBaseInfoService;
    @Autowired
    private CourseCategoryService courseCategoryService;

    @Test
    void testCourseBaseMapper() {
        System.out.println(courseBaseMapper.selectById(22));
    }

    @Test
    void testCourseBaseInfoService() {
        Long companyId = 1232141425L;
        System.out.println(courseBaseInfoService.queryCourseBaseList(companyId, new PageParams(), new QueryCourseParamsDto()));
    }

    @Test
    void testCourseCategoryService() {
        System.out.println(courseCategoryService.queryTreeNodes("1"));
    }

}
