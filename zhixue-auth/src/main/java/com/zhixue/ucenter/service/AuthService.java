package com.zhixue.ucenter.service;

import com.zhixue.ucenter.model.dto.AuthParamsDto;
import com.zhixue.ucenter.model.dto.XcUserExt;

/**
 * 认证 service
 */
public interface AuthService {

    /**
     * 认证方法
     *
     * @param authParamsDto 认证参数
     * @return {@link com.zhixue.ucenter.model.dto.XcUserExt} 用户信息
     * @author Wuxy
     * @since 2022/9/29 12:11
     */
    XcUserExt execute(AuthParamsDto authParamsDto);

}
