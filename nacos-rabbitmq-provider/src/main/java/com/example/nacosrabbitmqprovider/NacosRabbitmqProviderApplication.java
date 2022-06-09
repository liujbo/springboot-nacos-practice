package com.example.nacosrabbitmqprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.nacosrabbitmqprovider.mapper")
public class NacosRabbitmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRabbitmqProviderApplication.class, args);
    }

}
