package com.example.nacosrabbitmqprovider.service;

import com.example.nacosrabbitmqprovider.mapper.ConsumerMapper;
import com.example.nacosrabbitmqprovider.model.ConsumerInfoPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

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
        consumerMapper.add(consumerInfoPO);
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
    public List<ConsumerInfoPO> query(String consumerName, String consumerGender, String consumerFavorite, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ConsumerInfoPO> consumerInfoPOList = consumerMapper.query(consumerName, consumerGender, consumerFavorite);
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
        consumerMapper.update(consumerInfoPO);
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
        consumerMapper.delete(id);
        return "删除成功";
    }
}
