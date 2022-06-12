package com.example.nacosrocketmqconsumer.service;

import com.alibaba.fastjson2.JSONObject;

public interface IConsumerHistoryService {

    String saveHistory(JSONObject jsonObject);

    Object query(JSONObject jsonObject);
}
