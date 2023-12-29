package com.zhixue.learning.feignclient;

import com.zhixue.content.model.po.CoursePublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理服务远程接口
 */
@FeignClient(value = "content-api", fallbackFactory = ContentServiceClient.ContentServiceClientFallbackFactory.class)
public interface ContentServiceClient {

    @ResponseBody
    @GetMapping("/content/r/coursepublish/{courseId}")
    CoursePublish getCoursePublish(@PathVariable("courseId") Long courseId);

    /**
     * 内容管理服务远程接口降级类
     */
    @Slf4j
    class ContentServiceClientFallbackFactory implements FallbackFactory<ContentServiceClient> {

        @Override
        public ContentServiceClient create(Throwable cause) {
            log.error("调用内容管理服务接口熔断:{}", cause.getMessage());
            return null;
        }
    }
}
