package com.example.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Orderform;
import com.example.drug.mapper.OrderformMapper;
import com.example.drug.service.IOrderformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianxun
 * @since 2023-12-18
 */
@Service
public class OrderformServiceImpl extends ServiceImpl<OrderformMapper, Orderform> implements IOrderformService {

    @Autowired
    private OrderformMapper orderformMapper;
    @Override
    public IPage pageCC(Page<Orderform> page, Wrapper wrapper) {
        return orderformMapper.pageCC(page,wrapper);
    }
}
