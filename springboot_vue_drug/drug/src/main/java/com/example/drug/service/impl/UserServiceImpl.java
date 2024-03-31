package com.example.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Role;
import com.example.drug.entity.User;
import com.example.drug.entity.UserAndRole;
import com.example.drug.mapper.UserMapper;
import com.example.drug.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianxun
 * @since 2023-12-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public IPage pageC(IPage<User> page) {
        return userMapper.pageC(page);
    }

    @Override
    public IPage pageCC(Page<UserAndRole> page, Wrapper wrapper) {
        return userMapper.pageCC(page,wrapper);
    }

    @Override
    public List<User> listAll(LambdaQueryWrapper<User> lambdaQueryWrapper) {
        return userMapper.listAll(lambdaQueryWrapper);
    }

}
