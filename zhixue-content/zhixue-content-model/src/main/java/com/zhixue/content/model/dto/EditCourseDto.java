package com.zhixue.content.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 修改课程 dto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EditCourseDto extends AddCourseDto {

    /**
     * 课程 id
     */
    private Long id;

}
