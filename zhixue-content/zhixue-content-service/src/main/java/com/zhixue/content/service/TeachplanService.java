package com.zhixue.content.service;

import com.zhixue.content.model.dto.BindTeachplanMediaDto;
import com.zhixue.content.model.dto.SaveTeachplanDto;
import com.zhixue.content.model.dto.TeachplanDto;
import com.zhixue.content.model.po.TeachplanMedia;

import java.util.List;

/**
 * 课程计划业务接口
 */
public interface TeachplanService {

    /**
     * 查询课程计划树形结构
     *
     * @param courseId 课程id
     * @return 课程计划树形结构
     */
    List<TeachplanDto> findTeachplanTree(Long courseId);

    /**
     * 保存课程计划（新增/修改）
     *
     * @param teachplan 课程计划
     */
    void saveTeachplan(SaveTeachplanDto teachplan);

    /**
     * 教学计划绑定媒资
     *
     * @param bindTeachplanMediaDto 教学计划-媒资管理绑定数据
     * @return {@link com.zhixue.content.model.po.TeachplanMedia}
     * @author Mr.M
     * @since 2022/9/14 22:20
     */
    TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);

    /**
     * 删除指定教学计划-媒资绑定信息
     *
     * @param teachplanId 教学计划id
     * @param mediaId     媒资id
     */
    void deleteTeachplanMedia(Long teachplanId, String mediaId);

}
