package com.zhixue.content.service;

import com.zhixue.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * 课程分类 Service
 */
public interface CourseCategoryService {

    /**
     * 课程分类查询
     *
     * @param id 根节点 id
     * @return 根节点下的所有子节点
     */
    List<CourseCategoryTreeDto> queryTreeNodes(String id);

}
