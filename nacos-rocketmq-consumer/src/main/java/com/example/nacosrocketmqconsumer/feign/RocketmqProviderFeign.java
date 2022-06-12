package com.example.nacosrocketmqconsumer.feign;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nacos-rocketmq-provider", path = "/consumer")
public interface RocketmqProviderFeign {

    @PostMapping("/query")
    Object query(@RequestBody JSONObject jsonObject);

    @PostMapping("/add")
    String add(@RequestBody JSONObject jsonObject);
}
