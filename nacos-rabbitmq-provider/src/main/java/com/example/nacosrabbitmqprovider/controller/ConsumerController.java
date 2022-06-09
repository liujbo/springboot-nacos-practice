package com.example.nacosrabbitmqprovider.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.nacosrabbitmqprovider.model.ConsumerInfoPO;
import com.example.nacosrabbitmqprovider.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/query")
    public List<ConsumerInfoPO> query(@RequestBody Object object) {
        LOGGER.info("客户管理——查询接口，传入参数object：{}", JSON.toJSONString(object));
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object));
        String consumerName = jsonObject.getString("consumerName");
        String consumerGender = jsonObject.getString("consumerGender");
        String consumerFavorite = jsonObject.getString("consumerFavorite");
        int pageNum = jsonObject.getIntValue("pageNum");
        int pageSize = jsonObject.getIntValue("pageSize");
        return consumerService.query(consumerName, consumerGender, consumerFavorite, pageNum, pageSize);
    }

    @PostMapping("/add")
    public String add(@RequestBody Object object) {
        LOGGER.info("客户管理——新增接口，传入参数object：{}", JSON.toJSONString(object));
        ConsumerInfoPO consumerInfoPO = JSONObject.parseObject(JSON.toJSONString(object), ConsumerInfoPO.class);
        return consumerService.add(consumerInfoPO);
    }

    @PostMapping("/update")
    public String update(@RequestBody Object object) {
        LOGGER.info("客户管理——编辑接口，传入参数object：{}", JSON.toJSONString(object));
        ConsumerInfoPO consumerInfoPO = JSONObject.parseObject(JSON.toJSONString(object), ConsumerInfoPO.class);
        return consumerService.update(consumerInfoPO);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Object object) {
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object));
        String id = jsonObject.getString("id");
        return consumerService.delete(id);
    }
}
