package com.example.drug.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.entity.Drugrepertory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drug.entity.Repertory;
import com.example.drug.entity.UserAndRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qianxun
 * @since 2023-12-17
 */
@Mapper
public interface DrugrepertoryMapper extends BaseMapper<Drugrepertory> {
    @InterceptorIgnore(tenantLine = "1")
    @SuppressWarnings("MybatisXMapperMethodInspection")
    IPage pageCC(Page<Repertory> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
