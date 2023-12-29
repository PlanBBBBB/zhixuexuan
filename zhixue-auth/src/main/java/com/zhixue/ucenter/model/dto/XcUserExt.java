package com.zhixue.ucenter.model.dto;

import com.zhixue.ucenter.model.po.XcUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户扩展信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XcUserExt extends XcUser {
    /**
     * 用户权限
     */
    List<String> permissions = new ArrayList<>();

}
