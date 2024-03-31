package com.example.drug.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drug.entity.UserAndRole;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.bcel.classfile.Constant;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qianxun
 * @since 2023-12-09
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<User> {
    @SuppressWarnings("MybatisXMapperMethodInspection")
    IPage pageC(IPage<User> page);

    @InterceptorIgnore(tenantLine = "1")
    @SuppressWarnings("MybatisXMapperMethodInspection")
    IPage pageCC(Page<UserAndRole> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    List<User> listAll(@Param(Constants.WRAPPER) Wrapper wrapper);

}
