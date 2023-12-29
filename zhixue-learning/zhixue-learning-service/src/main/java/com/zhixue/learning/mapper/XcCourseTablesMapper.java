package com.zhixue.learning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixue.learning.model.dto.MyCourseTableItemDto;
import com.zhixue.learning.model.dto.MyCourseTableParams;
import com.zhixue.learning.model.po.XcCourseTables;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface XcCourseTablesMapper extends BaseMapper<XcCourseTables> {

    List<MyCourseTableItemDto> myCourseTables( MyCourseTableParams params);

    int myCourseTablesCount( MyCourseTableParams params);

}
