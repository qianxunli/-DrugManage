package com.example.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Drug;
import com.example.drug.entity.Drugrepertory;
import com.example.drug.entity.Repertory;
import com.example.drug.mapper.DrugrepertoryMapper;
import com.example.drug.service.IDrugrepertoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianxun
 * @since 2023-12-17
 */
@Service
public class DrugrepertoryServiceImpl extends ServiceImpl<DrugrepertoryMapper, Drugrepertory> implements IDrugrepertoryService {

    @Autowired
    private DrugrepertoryMapper drugrepertoryMapper;
    @Override
    public IPage pageCC(Page<Repertory> page, Wrapper wrapper) {
        return drugrepertoryMapper.pageCC(page,wrapper);
    }
}
