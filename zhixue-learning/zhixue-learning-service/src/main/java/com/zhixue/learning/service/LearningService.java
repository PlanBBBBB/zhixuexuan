package com.zhixue.learning.service;

import com.zhixue.base.model.RestResponse;

/**
 * 学习课程管理 service 接口
 */
public interface LearningService {

    /**
     * 获取教学视频
     *
     * @param courseId    课程id
     * @param teachplanId 课程计划id
     * @param mediaId     视频文件id
     * @return {@link com.zhixue.base.model.RestResponse}<{@link java.lang.String}>
     * @author Wuxy
     * @since 2022/10/5 9:08
     */
    RestResponse<String> getVideo(String userId, Long courseId, Long teachplanId, String mediaId);

}
