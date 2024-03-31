package com.example.drug.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Shoptrolley;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianxun
 * @since 2023-12-18
 */
public interface IShoptrolleyService extends IService<Shoptrolley> {

    IPage pageCC(Page<Shoptrolley> page, Wrapper wrapper);

}
