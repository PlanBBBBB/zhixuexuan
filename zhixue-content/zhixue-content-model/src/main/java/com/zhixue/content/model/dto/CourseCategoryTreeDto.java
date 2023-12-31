package com.zhixue.content.model.dto;

import com.zhixue.content.model.po.CourseCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 课程分类树型结点 dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseCategoryTreeDto extends CourseCategory {

    /**
     * 树形子节点
     */
    List<Object> childrenTreeNodes;

}
