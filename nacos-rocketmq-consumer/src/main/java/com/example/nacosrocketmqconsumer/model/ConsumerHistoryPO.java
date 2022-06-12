package com.example.nacosrocketmqconsumer.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("tb_consumer_history")
public class ConsumerHistoryPO {

    /**
     * 操作ID
     */
    @TableId
    private Long id;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 被添加人
     */
    private String consumerName;
    /**
     * 添加时间
     */
    @JsonFormat(timezone = "GTM+8", pattern = "yyyy-MM-dd")
    private Date createDate;
    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GTM+8", pattern = "yyyy-MM-dd")
    private Date modifyDate;
}
