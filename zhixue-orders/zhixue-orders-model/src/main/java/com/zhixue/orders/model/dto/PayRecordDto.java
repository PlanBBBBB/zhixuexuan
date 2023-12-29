package com.zhixue.orders.model.dto;

import com.zhixue.orders.model.po.XcPayRecord;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PayRecordDto extends XcPayRecord {

    //二维码
    private String qrcode;

}
