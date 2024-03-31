package com.example.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Drug;
import com.example.drug.entity.User;
import com.example.drug.entity.UserAndRole;
import com.example.drug.mapper.DrugMapper;
import com.example.drug.service.IDrugService;
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
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements IDrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public IPage pageCC(Page<Drug> page, Wrapper wrapper) {
        return drugMapper.pageCC(page,wrapper);
    }
}
