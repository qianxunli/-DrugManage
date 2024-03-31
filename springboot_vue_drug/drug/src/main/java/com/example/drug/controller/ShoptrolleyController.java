package com.example.drug.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.common.QueryPageParam;
import com.example.drug.common.Result;
import com.example.drug.entity.Drug;
import com.example.drug.entity.Shoptrolley;
import com.example.drug.service.impl.DrugServiceImpl;
import com.example.drug.service.impl.ShoptrolleyServiceImpl;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianxun
 * @since 2023-12-18
 */
@RestController
@RequestMapping("/drug/shoptrolley")
public class ShoptrolleyController {
    @Autowired
    private ShoptrolleyServiceImpl shoptrolleyService;

//    @GetMapping("/findByid")
//    public Result findByno(@RequestParam String drugid){
//        System.out.println("药品id="+drugid);
//        List list = shoptrolleyService.lambdaQuery().eq(Shoptrolley::getShoptrolleyid,drugid).list();
//        return list.isEmpty()?Result.fail():Result.suc(list);
//    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Shoptrolley shoptrolley){
        System.out.println("购物车保存="+shoptrolley.toString());
        return shoptrolleyService.save(shoptrolley)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Shoptrolley shoptrolley){

        return shoptrolleyService.updateById(shoptrolley)?Result.suc():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveorupdate")
    public Result saveOrUpdate(@RequestBody Shoptrolley shoptrolley){

        return shoptrolleyService.saveOrUpdate(shoptrolley)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public Result del(@RequestParam String shoptrolleyid){
        return shoptrolleyService.removeById(shoptrolleyid)?Result.suc():Result.fail();
    }

    @PostMapping("/listpageC1")
    public Result listpageC1(@RequestBody QueryPageParam query){
        HashMap param=query.getParam();
//        String drugname= String.valueOf(param.get("drugname"));
        String drugname= String.valueOf(param.get("drugname"));
        String userid = String.valueOf(param.get("userid"));
        System.out.println("用户id=="+userid);
        System.out.println("药品名称"+drugname);
        Page<Shoptrolley> page= new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Shoptrolley> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(drugname)&&!"null".equals(drugname)){
            lambdaQueryWrapper.like(Shoptrolley::getDrugname,drugname);//eq完全匹配
        }
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(userid),Shoptrolley::getUserid,userid);

        IPage result =shoptrolleyService.pageCC(page,lambdaQueryWrapper);

        return Result.suc(result.getRecords(),result.getTotal());
    }
}
