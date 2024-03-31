package com.example.drug.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.common.QueryPageParam;
import com.example.drug.common.Result;
import com.example.drug.entity.Orderform;
import com.example.drug.entity.Shoptrolley;
import com.example.drug.service.impl.OrderformServiceImpl;
import com.example.drug.service.impl.ShoptrolleyServiceImpl;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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
@RequestMapping("/drug/orderform")
public class OrderformController {
    @Autowired
    private OrderformServiceImpl orderformService;

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Orderform orderform){
        System.out.println("购物车保存="+orderform.toString());
        boolean temp=true;
        boolean order=orderformService.save(orderform);
        Integer orderid=0;
        if(order){
            List<Orderform> list =orderformService.list();
            for(Orderform or : list){
                if(or.getOrdernumber()==null){
                    or.setOrdernumber(or.getOrderformid());
                    orderid=or.getOrderformid();
                    System.out.println("获取订单的id="+orderid);
                    System.out.println(or.getOrdernumber()+"|?|"+or.getOrderformid());
                    temp=orderformService.saveOrUpdate(or);
                    if(!temp){
                        break;
                    }
                }
            }
            if(temp){
               return Result.suc(orderid);
            }else{
               return Result.fail();
            }
        }
        return order?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Orderform orderform){

        return orderformService.updateById(orderform)?Result.suc():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveorupdate")
    public Result saveOrUpdate(@RequestBody Orderform orderform){

        return orderformService.saveOrUpdate(orderform)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public Result del(@RequestParam String orderformid){
        return orderformService.removeById(orderformid)?Result.suc():Result.fail();
    }

    @PostMapping("/listpageC1")
    public Result listpageC1(@RequestBody QueryPageParam query){
        HashMap param=query.getParam();
//        String drugname= String.valueOf(param.get("drugname"));
        String rolename= String.valueOf(param.get("rolename"));
        String userid = String.valueOf(param.get("userid"));
        System.out.println("用户id=="+userid);
        System.out.println("用户权限"+rolename);
        Page<Orderform> page= new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Orderform> lambdaQueryWrapper= new LambdaQueryWrapper<>();
//        if(StringUtils.isNotBlank(drugname)&&!"null".equals(drugname)){
//            lambdaQueryWrapper.like(Shoptrolley::getDrugname,drugname);//eq完全匹配
//        }
        if(rolename.equals("管理员")||rolename.equals("员工")){
//            lambdaQueryWrapper
        }else{
            lambdaQueryWrapper.eq(StringUtils.isNotBlank(userid),Orderform::getUserid,userid);
        }
        IPage result =orderformService.pageCC(page,lambdaQueryWrapper);
        System.out.println("");

        return Result.suc(result.getRecords(),result.getTotal());
    }

}
