package com.xuecheng.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 错误响应参数包装
 */
@Data
@AllArgsConstructor
public class RestErrorResponse {

    /**
     * 异常信息
     */
    private String errMessage;

}
