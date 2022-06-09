package com.example.nacoskafkaprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.nacoskafkamqprovider.mapper")
public class NacosKafkaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosKafkaProviderApplication.class, args);
    }

}
