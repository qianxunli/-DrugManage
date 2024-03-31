package com.example.drug.controller;


import com.example.drug.common.Result;
import com.example.drug.entity.Menu;
import com.example.drug.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianxun
 * @since 2023-12-16
 */
@RestController
@RequestMapping("/drug/menu")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        System.out.println("权限="+roleId);
        List list=menuService.lambdaQuery().like(Menu::getMenuright,roleId).list();
        return Result.suc(list);
    }

}
