package com.example.nacosprovider.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ConsumerInfoPO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 客户姓名
     */
    private String consumerName;
    /**
     * 客户出生年月
     */
    @JsonFormat(timezone = "GTM+8", pattern = "yyyy-MM-dd")
    private Date consumerBirthday;
    /**
     * 客户性别
     */
    private String consumerGender;
    /**
     * 客户地址
     */
    private String consumerAddress;
    /**
     * 客户喜好
     */
    private String consumerFavorite;
}
