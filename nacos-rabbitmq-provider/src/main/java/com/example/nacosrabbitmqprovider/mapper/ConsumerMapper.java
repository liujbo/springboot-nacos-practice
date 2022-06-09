package com.example.nacosrabbitmqprovider.mapper;

import com.example.nacosrabbitmqprovider.model.ConsumerInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConsumerMapper {

    /**
     * 查询客户信息
     *
     * @param consumerName     客户姓名
     * @param consumerGender   客户性别
     * @param consumerFavorite 客户爱好
     * @return 客户信息集合
     */
    List<ConsumerInfoPO> query(String consumerName, String consumerGender, String consumerFavorite);

    /**
     * 根据ID查询客户信息
     *
     * @param id 客户信息主键ID
     * @return 客户信息
     */
    ConsumerInfoPO queryById(@Param("id") String id);

    /**
     * 新增客户信息
     *
     * @param consumerInfoPO 客户信息对象
     */
    void add(ConsumerInfoPO consumerInfoPO);

    /**
     * 批量新增客户信息
     *
     * @param consumerInfoPOList 客户信息集合
     */
    void batchAdd(List<ConsumerInfoPO> consumerInfoPOList);

    /**
     * 删除客户信息
     *
     * @param id 客户信息主键ID
     */
    void delete(@Param("id") String id);

    /**
     * 更新客户信息
     *
     * @param consumerInfoPO 客户信息对象
     */
    void update(ConsumerInfoPO consumerInfoPO);
}
