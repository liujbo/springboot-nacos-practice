package com.example.nacosrocketmqprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.nacosrocketmqprovider.mapper")
public class NacosRocketmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRocketmqProviderApplication.class, args);
    }

}
