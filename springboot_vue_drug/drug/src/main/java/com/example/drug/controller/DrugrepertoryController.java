package com.example.drug.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.common.QueryPageParam;
import com.example.drug.common.Result;
import com.example.drug.entity.Drug;
import com.example.drug.entity.Druglift;
import com.example.drug.entity.Drugrepertory;
import com.example.drug.entity.Repertory;
import com.example.drug.service.impl.DrugServiceImpl;
import com.example.drug.service.impl.DrugrepertoryServiceImpl;
import io.micrometer.common.util.StringUtils;
import jdk.javadoc.doclet.Reporter;
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
@RequestMapping("/drug/drugrepertory")
public class DrugrepertoryController {
    @Autowired
    private DrugrepertoryServiceImpl drugrepertoryService;

    @GetMapping("/findByid")
    public Result findByno(@RequestParam String drugrepertoryid){
        System.out.println("药品id="+drugrepertoryid);
        List list = drugrepertoryService.lambdaQuery().eq(Drugrepertory::getDrugrepertoryid,drugrepertoryid).list();
        return list.isEmpty()?Result.fail():Result.suc(list);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Drugrepertory drugrepertory){
        System.out.println("药品保存="+drugrepertory.toString());
        return drugrepertoryService.save(drugrepertory)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Drugrepertory drugrepertory){
        System.out.println("kuncu库存id="+drugrepertory.getDrugrepertoryid());
        List<Drugrepertory> list = drugrepertoryService.lambdaQuery().eq(Drugrepertory::getDrugrepertoryid,drugrepertory.getDrugrepertoryid()).list();
        for(Drugrepertory drugrepertory1 : list){
             if(drugrepertory.getDrugrepertoryid()==drugrepertory1.getDrugrepertoryid()){
                 System.out.println("库存id="+drugrepertory.getDrugrepertoryid());
                 drugrepertory.setDrugtimeremain(drugrepertory1.getDrugtimeremain());
             }
            System.out.println("kuncu库时间d="+drugrepertory1.getDrugtimeremain());
        }
        return drugrepertoryService.updateById(drugrepertory)?Result.suc():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveorupdate")
    public Result saveOrUpdate(@RequestBody Drugrepertory drugrepertory){


        return drugrepertoryService.saveOrUpdate(drugrepertory)?Result.suc():Result.fail();
    }

    //删除
    @GetMapping("/delete")
    public Result del(@RequestParam String drugrepertoryid){
        return drugrepertoryService.removeById(drugrepertoryid)?Result.suc():Result.fail();
    }

    public String calculateRemainingShelfLife(LocalDate drugbirthday, Integer drugshelflife) {
        int date=0;
        StringBuilder res = new StringBuilder();
        LocalDate today = LocalDate.now();
        LocalDate expirationDate = drugbirthday.plusMonths(drugshelflife);

        // 使用Period计算两个日期之间的差距
        Period period = Period.between(today, expirationDate);

        int remainingYears = period.getYears();
        int remainingMonths = period.getMonths();
        int remainingDays = period.getDays();
        if(remainingYears<=0&&remainingMonths<=0){
            if(remainingDays<=0){
//                String.format("已过期%d年%d个月%d天", remainingYears,remainingMonths, remainingDays);
                res.append("已过期").append(Math.abs(remainingYears)).append("年").append(Math.abs(remainingMonths))
                        .append("个月").append(Math.abs(remainingDays)).append("天").append(",").append(0);
                return String.valueOf(res);
            }else{
                res.append("还有").append(remainingYears).append("年").append(remainingMonths)
                        .append("个月").append(remainingDays).append("天过期").append(",").append(1);
                return String.valueOf(res);
            }

        }else{
//            return String.format("%d年%d个月%d天", remainingYears,remainingMonths, remainingDays);
            res.append(remainingYears).append("年").append(remainingMonths)
                    .append("个月").append(remainingDays).append("天").append(",").append(2);
            return String.valueOf(res);
        }
    }


    @PostMapping("/listpageC1")
    public Result listpageC1(@RequestBody QueryPageParam query){
        HashMap param=query.getParam();
        String drugid= String.valueOf(param.get("drugid"));
        Page<Repertory> page= new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Drugrepertory> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(drugid)&&!"null".equals(drugid)){
            lambdaQueryWrapper.like(Drugrepertory::getDrugrepertoryid,drugid);//eq完全匹配
        }

        IPage result =drugrepertoryService.pageCC(page,lambdaQueryWrapper);


        List<Repertory> records = result.getRecords();

        // 遍历列表，为每个元素加入额外的数据
        for (Repertory repertory: records) {
            String info[]=calculateRemainingShelfLife(repertory.getDrugbirthday(),repertory.getDrugshelflife()).split(",");
//            System.out.println(info[0]+"||||"+info[1]);
            // 在这里加入额外的数据
            repertory.setDrugresidue(info[0]);
            repertory.setState(Integer.valueOf(info[1]));
        }
//        for (Repertory repertory: records) {
//            // 在这里加入额外的数据
//            System.out.println("剩余时间="+repertory);
//        }
        //System.out.println("剩余时间="+records);
//        return Result.suc(result.getRecords(),result.getTotal());
        return Result.suc(records,result.getTotal());

//        return Result.suc(result.getRecords(),result.getTotal());
    }
    @GetMapping("/listC")
    public Result listC(@RequestParam String drugid){


        //System.out.println("药品名称id="+drugid);
        List list = drugrepertoryService.lambdaQuery().eq(Drugrepertory::getDrugid,drugid).list();
        return list.isEmpty()?Result.fail():Result.suc(list);

    }
}
