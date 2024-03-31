package com.example.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Shoptrolley;
import com.example.drug.entity.UserAndRole;
import com.example.drug.mapper.ShoptrolleyMapper;
import com.example.drug.service.IShoptrolleyService;
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
public class ShoptrolleyServiceImpl extends ServiceImpl<ShoptrolleyMapper, Shoptrolley> implements IShoptrolleyService {

    @Autowired
    private ShoptrolleyMapper shoptrolleyMapper;
    @Override
    public IPage pageCC(Page<Shoptrolley> page, Wrapper wrapper) {
        return shoptrolleyMapper.pageCC(page,wrapper);
    }
}
