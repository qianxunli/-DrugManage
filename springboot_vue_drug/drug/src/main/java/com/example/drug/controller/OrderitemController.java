package com.example.drug.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.common.QueryPageParam;
import com.example.drug.common.Result;
import com.example.drug.entity.*;
import com.example.drug.service.impl.DrugServiceImpl;
import com.example.drug.service.impl.OrderformServiceImpl;
import com.example.drug.service.impl.OrderitemServiceImpl;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianxun
 * @since 2023-12-18
 */
@RestController
@RequestMapping("/drug/orderitem")
public class OrderitemController {
    @Autowired
    private OrderitemServiceImpl orderitemService;
    @Autowired
    private DrugServiceImpl drugService;

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Orderitem orderitem){
        System.out.println("订单项保存="+orderitem.toString());
        return orderitemService.save(orderitem)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Orderitem orderitem){

        return orderitemService.updateById(orderitem)?Result.suc():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveorupdate")
    public Result saveOrUpdate(@RequestBody Orderitem orderitem){

        return orderitemService.saveOrUpdate(orderitem)?Result.suc():Result.fail();
    }
    //删除
    @GetMapping("/delete")
    public Result del(@RequestParam String orderitemid){
        return orderitemService.removeById(orderitemid)?Result.suc():Result.fail();
    }
    @GetMapping("/listC")
    public Result listC(@RequestParam String orderformid){
        System.out.println("订单id="+orderformid);
        List<Orderitem> list = orderitemService.lambdaQuery()
                .eq(Orderitem::getOrderformid,orderformid).list();
        List<Item> items = list.stream()
                .map(Item::new) // 使用 Item 的构造函数将 Orderitem 转换为 Item
                .collect(Collectors.toList());

        List<Drug> druglist = drugService.list();
        for(Item item: items){
            for(Drug drug:druglist){
                if(item.getDrugid()==drug.getdrugid()){
                    item.setDrugname(drug.getdrugname());
                }
            }
            System.out.println("item订单项="+item);
        }
        return list.isEmpty()?Result.fail():Result.suc(items);
    }

}
