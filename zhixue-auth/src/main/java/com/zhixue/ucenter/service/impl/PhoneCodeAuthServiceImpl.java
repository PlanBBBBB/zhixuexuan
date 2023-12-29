package com.zhixue.ucenter.service.impl;

import com.zhixue.ucenter.feignclient.CheckCodeClient;
import com.zhixue.ucenter.model.dto.AuthParamsDto;
import com.zhixue.ucenter.model.dto.XcUserExt;
import com.zhixue.ucenter.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 手机验证码登录
 */
@Service("phone_authservice")
public class PhoneCodeAuthServiceImpl implements AuthService {

    @Autowired
    private CheckCodeClient checkCodeClient;


    @Override
    public XcUserExt execute(AuthParamsDto authParamsDto) {
        // 获取手机验证码
        String checkcode = authParamsDto.getCheckcode();
        // 获取验证码key
        String checkcodekey = authParamsDto.getCheckcodekey();

        if (!checkCodeClient.verify(checkcodekey, checkcode)) {
            throw new RuntimeException("验证码错误");
        }

        // 获取手机号
        String phone = authParamsDto.getCellphone();
        // 根据手机号生成用户信息并添加到数据库
        return null;
    }
}
