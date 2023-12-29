package com.zhixue.content.model.dto;

import com.zhixue.content.model.po.Teachplan;
import com.zhixue.content.model.po.TeachplanMedia;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class TeachplanDto extends Teachplan {

    /**
     * 关联的媒资信息
     */
    TeachplanMedia teachplanMedia;

    /**
     * 子目录
     */
    List<TeachplanDto> teachPlanTreeNodes;

}
