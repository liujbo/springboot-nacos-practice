package com.example.nacosrocketmqconsumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nacosrocketmqconsumer.model.ConsumerHistoryPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerHistoryMapper extends BaseMapper<ConsumerHistoryPO> {
}
