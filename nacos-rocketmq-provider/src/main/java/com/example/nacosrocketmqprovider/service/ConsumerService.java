package com.example.nacosrocketmqprovider.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nacosrocketmqprovider.mapper.ConsumerMapper;
import com.example.nacosrocketmqprovider.model.ConsumerInfoPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    /**
     * 新增客户信息
     *
     * @param consumerInfoPO 客户信息对象
     * @return 操作结果
     */
    @Transactional(rollbackFor = Exception.class)
    public String add(ConsumerInfoPO consumerInfoPO) {
        consumerMapper.insert(consumerInfoPO);
        return "新增成功";
    }

    /**
     * 查询客户信息
     *
     * @param consumerName     客户姓名
     * @param consumerGender   客户性别
     * @param consumerFavorite 客户爱好
     * @param pageNum          页码
     * @param pageSize         每页条数
     * @return 客户信息集合
     */
    public Object query(String consumerName, String consumerGender, String consumerFavorite, int pageNum, int pageSize) {
        LambdaQueryWrapper<ConsumerInfoPO> wrapper = new QueryWrapper<ConsumerInfoPO>().lambda();
        wrapper.like(StringUtils.isNotEmpty(consumerName), ConsumerInfoPO::getConsumerName, consumerName)
                .eq(StringUtils.isNotEmpty(consumerGender), ConsumerInfoPO::getConsumerGender, consumerGender)
                .like(StringUtils.isNotEmpty(consumerFavorite), ConsumerInfoPO::getConsumerFavorite, consumerFavorite);

        PageHelper.startPage(pageNum, pageSize);
        List<ConsumerInfoPO> consumerInfoPOList = consumerMapper.selectList(wrapper);
        PageInfo<ConsumerInfoPO> pageInfo = new PageInfo<>(consumerInfoPOList);
        if (CollectionUtils.isEmpty(pageInfo.getList())) {
            return null;
        }
        return pageInfo.getList();
    }

    /**
     * 编辑客户信息
     *
     * @param consumerInfoPO 客户信息对象
     * @return 结果信息
     */
    @Transactional(rollbackFor = Exception.class)
    public String update(ConsumerInfoPO consumerInfoPO) {
        consumerMapper.updateById(consumerInfoPO);
        return "编辑成功";
    }

    /**
     * 删除客户信息
     *
     * @param id 客户信息主键ID
     * @return 结果信息
     */
    @Transactional(rollbackFor = Exception.class)
    public String delete(String id) {
        consumerMapper.deleteById(id);
        return "删除成功";
    }
}
