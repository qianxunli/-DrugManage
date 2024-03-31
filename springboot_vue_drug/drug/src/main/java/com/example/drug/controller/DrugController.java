package com.example.drug.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.common.QueryPageParam;
import com.example.drug.common.Result;
import com.example.drug.entity.*;
import com.example.drug.service.impl.*;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianxun
 * @since 2023-12-17
 */
@RestController
@RequestMapping("/drug/drug")
public class DrugController {

    @Autowired
    private DrugServiceImpl drugService;

    @GetMapping("/findByid")
    public Result findByno(@RequestParam String drugid){
        System.out.println("药品id="+drugid);
        List list = drugService.lambdaQuery().eq(Drug::getdrugid,drugid).list();
        return list.isEmpty()?Result.fail():Result.suc(list);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Drug drug){
        System.out.println("药品保存="+drug.toString());
        return drugService.save(drug)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Drug drug){

        return drugService.updateById(drug)?Result.suc():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveorupdate")
    public Result saveOrUpdate(@RequestBody Drug drug){

        return drugService.saveOrUpdate(drug)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public Result del(@RequestParam String drugid){
        return drugService.removeById(drugid)?Result.suc():Result.fail();
    }

    // 计算保质期剩余时间的方法
//    public String calculateRemainingShelfLife(LocalDate drugbirthday,Integer drugshelflife) {
//        LocalDate today = LocalDate.now();
//        LocalDate expirationDate = drugbirthday.plusMonths(drugshelflife);
//
//        // 使用Period计算两个日期之间的差距
//        Period period = Period.between(today, expirationDate);
//
//        int remainingMonths = period.getMonths();
//        int remainingDays = period.getDays();
//
//        return String.format("%d个月%d天", remainingMonths, remainingDays);
//    }

    @PostMapping("/listpageC1")
    public Result listpageC1(@RequestBody QueryPageParam query){
        HashMap param=query.getParam();
        String drugname= String.valueOf(param.get("drugname"));
        System.out.println("药品名称"+drugname);
        Page<Drug> page= new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Drug> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(drugname)&&!"null".equals(drugname)){
            lambdaQueryWrapper.like(Drug::getdrugname,drugname);//eq完全匹配
        }

        IPage result =drugService.pageCC(page,lambdaQueryWrapper);

//        List<Druglift> records = result.getRecords();
//
//        // 遍历列表，为每个元素加入额外的数据
//        for (Druglift drug : records) {
//            // 在这里加入额外的数据
//            drug.setDrugresidue(calculateRemainingShelfLife(drug.getdrugbirthday(),drug.getdrugshelflife()));
//        }
//        for (Druglift drug : records) {
//            // 在这里加入额外的数据
//            System.out.println("剩余时间="+drug);
//        }
//        System.out.println("剩余时间="+records);
//        return Result.suc(records,result.getTotal());
        return Result.suc(result.getRecords(),result.getTotal());
    }

}
