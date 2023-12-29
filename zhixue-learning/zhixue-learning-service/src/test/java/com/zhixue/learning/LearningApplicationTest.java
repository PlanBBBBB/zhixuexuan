package com.zhixue.learning;

import com.zhixue.base.model.PageResult;
import com.zhixue.content.model.po.CoursePublish;
import com.zhixue.learning.feignclient.ContentServiceClient;
import com.zhixue.learning.model.dto.MyCourseTableItemDto;
import com.zhixue.learning.model.dto.MyCourseTableParams;
import com.zhixue.learning.service.MyCourseTablesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LearningApplicationTest {

    @Autowired
    ContentServiceClient contentServiceClient;

    @Autowired
    MyCourseTablesService myCourseTablesService;

    @Test
    public void test() {
        CoursePublish coursepublish = contentServiceClient.getCoursePublish(2L);
        System.out.println(coursepublish);
    }

    @Test
    public void test2() {
        MyCourseTableParams myCourseTableParams = new MyCourseTableParams();
        myCourseTableParams.setUserId("52");
        PageResult<MyCourseTableItemDto> myCourseTables = myCourseTablesService.myCourseTables(myCourseTableParams);
        System.out.println(myCourseTables);
    }

}
