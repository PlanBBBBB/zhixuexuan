package com.zhixue.messagesdk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixue.messagesdk.mapper.MqMessageHistoryMapper;
import com.zhixue.messagesdk.model.po.MqMessageHistory;
import com.zhixue.messagesdk.service.MqMessageHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 */
@Slf4j
@Service
public class MqMessageHistoryServiceImpl extends ServiceImpl<MqMessageHistoryMapper, MqMessageHistory> implements MqMessageHistoryService {

}
