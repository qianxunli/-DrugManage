package com.example.drug.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Role;
import com.example.drug.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.drug.entity.UserAndRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianxun
 * @since 2023-12-09
 */
public interface IUserService extends IService<User> {

    IPage pageC(IPage<User> page);

    IPage pageCC(Page<UserAndRole> page, Wrapper wrapper);

    List<User> listAll(LambdaQueryWrapper<User> lambdaQueryWrapper);


}
