package com.zhixue.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixue.content.model.dto.TeachplanDto;
import com.zhixue.content.model.po.Teachplan;

import java.util.List;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    // 查询课程计划（组成树形结构）
    List<TeachplanDto> selectTreeNodes(Long courseId);

}
