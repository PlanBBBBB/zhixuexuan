package com.zhixue.learning.model.dto;

import com.zhixue.learning.model.po.XcCourseTables;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 我的课程查询条件
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class MyCourseTableItemDto extends XcCourseTables {

    /**
     * 最近学习时间
     */
    private LocalDateTime learnDate;

    /**
     * 学习时长
     */
    private Long learnLength;

    /**
     * 章节id
     */
    private Long teachplanId;

    /**
     * 章节名称
     */
    private String teachplanName;

}
