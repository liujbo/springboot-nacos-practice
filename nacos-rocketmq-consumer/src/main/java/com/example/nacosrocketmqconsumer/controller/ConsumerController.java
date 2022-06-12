package com.example.nacosrocketmqconsumer.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.nacosrocketmqconsumer.service.IConsumerHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @Autowired
    private IConsumerHistoryService iConsumerHistoryService;

    @PostMapping("/add")
    public String addConsumer(@RequestBody JSONObject jsonObject) {
        log.info("服务消费者，添加用户信息接口传入参数为：{}", jsonObject.toJSONString());
        return iConsumerHistoryService.saveHistory(jsonObject);
    }

    @PostMapping("/query")
    public Object getAll(@RequestBody JSONObject jsonObject) {
        log.info("服务消费者，查询用户信息接口传入参数为：{}", jsonObject.toJSONString());
        return iConsumerHistoryService.query(jsonObject);
    }
}
