package com.example.drug.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Drug;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.drug.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianxun
 * @since 2023-12-17
 */
public interface IDrugService extends IService<Drug> {


    IPage pageCC(Page<Drug> page,  Wrapper wrapper);
}
