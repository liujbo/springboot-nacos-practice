package com.example.nacosrocketmqconsumer.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.example.nacosrocketmqconsumer.feign.RocketmqProviderFeign;
import com.example.nacosrocketmqconsumer.model.ConsumerHistoryPO;
import com.example.nacosrocketmqconsumer.service.IConsumerHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户操作历史记录service
 */
@Service
@Slf4j
public class ConsumerHistoryServiceImpl implements IConsumerHistoryService {

    @Autowired
    private RocketmqProviderFeign rocketmqProviderFeign;

    /**
     * 新增
     *
     * @param jsonObject
     */
    @Override
    public String saveHistory(JSONObject jsonObject) {
        log.info("添加用户信息操作记录接口，传入参数：{}", jsonObject.toJSONString());
        ConsumerHistoryPO consumerHistoryPO = new ConsumerHistoryPO();
        consumerHistoryPO.setOperator("管理员");
        consumerHistoryPO.setConsumerName(jsonObject.getString("consumerName"));
        consumerHistoryPO.setCreateDate(new Date());

        //远程调用添加客户信息
        rocketmqProviderFeign.add(jsonObject);
        return "添加成功";
    }

    /**
     * 查询
     *
     * @param jsonObject
     * @return
     */
    @Override
    public Object query(JSONObject jsonObject) {
        return null;
    }
}
