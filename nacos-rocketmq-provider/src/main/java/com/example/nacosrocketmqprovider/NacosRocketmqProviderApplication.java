package com.example.nacosrocketmqprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.example.nacosrocketmqprovider.mapper")
@EnableDiscoveryClient
public class NacosRocketmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRocketmqProviderApplication.class, args);
    }

}
