package com.example.drug.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drug.common.QueryPageParam;
import com.example.drug.common.Result;
import com.example.drug.entity.*;
import com.example.drug.mapper.UserMapper;
import com.example.drug.service.impl.MenuServiceImpl;
import com.example.drug.service.impl.RoleServiceImpl;
import com.example.drug.service.impl.UserServiceImpl;
import com.example.drug.service.impl.UserroleServiceImpl;
import com.github.yulichang.interfaces.MPJBaseJoin;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianxun
 * @since 2023-12-09
 */
//@Controller
@CrossOrigin
@RestController
@RequestMapping("/drug/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private UserroleServiceImpl userroleService;

    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    @GetMapping("/findByno")
    public Result findByno(@RequestParam String username){
        List list = userService.lambdaQuery().eq(User::getUserName, username)
                .select(User::getUserName).list();
        return list.isEmpty()?Result.fail():Result.suc(list);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody UserAndRole userAndRole){
        List<Role> role=roleService.list();
        System.out.println("UsrAndRole=="+userAndRole);
        Userrole userRole= new Userrole();
        User user=new User(userAndRole);
        if(user.getPassword().isEmpty()){
            user.setPassword("123");
            System.out.println("kong空");
        }
        boolean saveUserResult = userService.save(user);
        System.out.println("user="+user.toString());

        if (saveUserResult) {
            for (Role roles : role) {
                if (userAndRole.getRolename().equals(roles.getRoleName())) {
                    userRole.setRoleId(roles.getRoleId());
                    userRole.setUserId(user.getUserid());
                    userRole.setUserRoleId(user.getUserid());
                    break;
                } else {
                    System.out.println("role error");
                }
            }
            boolean saveUserRoleResult = userroleService.save(userRole);
            return (saveUserResult && saveUserRoleResult) ? Result.suc() : Result.fail();
        }else{
            return Result.fail();
        }
//        return userService.saveAll(user,role)?Result.suc():Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody UserAndRole userAndRole){
        List<Role> role=roleService.list();
        Userrole userRole= new Userrole();
        userRole.setUserId(userAndRole.getUserid());
        userRole.setUserRoleId(userAndRole.getUserid());
        User user=new User(userAndRole);
        String pass= String.valueOf(userService.lambdaQuery().eq(User::getUserName, user.getUserid())
                .select(User::getPassword).list());
        System.out.println("pas+="+pass);
        System.out.println("个人信息密码"+user.getPassword());
        if(user.getPassword()==null){
            System.out.println("信息密码"+user.getPassword());
            List<User> list=userService.lambdaQuery().eq(User::getUserName, user.getUserName())
                    .select(User::getPassword).list();
            System.out.println("密码list="+list);
            for(User u: list){
                if(!u.getPassword().isEmpty()){
                    user.setPassword(u.getPassword());
                    break;
                }
            }
        }

//        user.setPassword(pass);
        boolean saveUserResult = userService.updateById(user);
        if (saveUserResult) {
            for (Role roles : role) {
                if (userAndRole.getRolename().equals(roles.getRoleName())) {
                    userRole.setRoleId(roles.getRoleId());
                    break;
                } else {
                    System.out.println("role error");
                }
            }
            boolean saveUserRoleResult = userroleService.updateById(userRole);
            return (saveUserResult && saveUserRoleResult) ? Result.suc() : Result.fail();
        }else{
            return Result.fail();
        }
    }
    @PostMapping("/login")
    public Result login(@RequestBody UserAndRole userAndRole){
        List<Role> role=roleService.list();
        User user=new User(userAndRole);
        Integer userid=null;
        Integer RoleId=null;
        List<User> list= userService.lambdaQuery()
                .select(User::getUserid,User::getUserName,User::getPassword,User::getName,User::getBirthday,User::getTelephone,User::getAddress)
                .eq(User::getUserName,user.getUserName())
                .eq(User::getPassword,user.getPassword()).list();
        if(!list.isEmpty()){
            for(User u:list){
                userid=u.getUserid();
                Userrole userrole=userroleService.lambdaQuery().eq(Userrole::getUserId,userid).one();
                RoleId=userrole.getRoleId();
                if(userrole!=null){
                    for (Role roles : role) {
                        if (RoleId.equals(roles.getRoleId())) {
                            u.setRolename(roles.getRoleName());
                            break;
                        } else {
                            System.out.println("role error");
                        }
                    }
                }
            }
        }else{
            System.out.println("查无此人");
        }
        if(!list.isEmpty()){
            System.out.println("信息list="+list);
//            User userInfo = list.get(0);

//            System.out.println("信息useronfo="+userInfo);
            List menuList=menuService.lambdaQuery().like(Menu::getMenuright,RoleId).list();
            System.out.println("信息menu="+menuList);
            HashMap res=new HashMap();
            res.put("user",list);
            res.put("menu",menuList);
            return Result.suc(res);
        }
//        return !list.isEmpty()? Result.suc(list) : Result.fail();
        return Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String userid){
        System.out.println("用户id="+userid);
        boolean removeUserRole=userroleService.removeById(userid);
        boolean removeUser=userService.removeById(userid);
        return (removeUser&&removeUserRole)?Result.suc():Result.fail();
    }

    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }

    //新增或修改
    @PostMapping("/saveorupdate")
    public boolean saveOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    @PostMapping("/listAll")
    public Result listAll(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(String.valueOf(user.getUserid()))){
            lambdaQueryWrapper.like(User::getUserid,user.getUserid());//eq完全匹配
        }

        return Result.suc(userService.listAll(lambdaQueryWrapper));
    }
    //查询（模糊、匹配
    @PostMapping("/listp")
    public List<User> listp(@RequestBody UserAndRole userAndRole){
        User user=new User(userAndRole);
        LambdaQueryWrapper<User> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(user.getName())){
            lambdaQueryWrapper.like(User::getName,user.getName());//eq完全匹配
        }
        System.out.println("user.getName()="+user.getName());
//        return userMapper.listAll(lambdaQueryWrapper);
        return userService.listAll(lambdaQueryWrapper);
    }
    @PostMapping("/listpage")
//    public List<User> listpage(@RequestBody HashMap map){
    public List<User> listpage(@RequestBody QueryPageParam query){
        //System.out.println(query);
        System.out.println("pageSize="+query.getPageSize());
        System.out.println("PageNum="+query.getPageNum());
        HashMap param=query.getParam();
//        System.out.println("name="+param.get("userName"));
//        System.out.println("telephone="+param.get("telephone"));
//        LambdaQueryWrapper<User> lambdaQueryWrapper= new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(User::getTelephone,user.getTelephone());//eq完全匹配
//        return userService.list(lambdaQueryWrapper);
        Page<User> page= new Page<>(1,2);
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getTelephone,param.get("telephone"));//eq完全匹配

        IPage result =userService.page(page,lambdaQueryWrapper);

        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listpageC")
    public List<User> listpageC(@RequestBody QueryPageParam query){
        System.out.println("pageSize="+query.getPageSize());
        System.out.println("PageNum="+query.getPageNum());
        HashMap param=query.getParam();
        Page<UserAndRole> page= new Page<>(1,2);
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,"张");//eq完全匹配
//        IPage result =userService.pageC(page);
        IPage result =userService.pageCC(page,lambdaQueryWrapper);

        System.out.println("total=="+result.getTotal());


        return result.getRecords();
    }
    @PostMapping("/listpageC1")
    public Result listpageC1(@RequestBody QueryPageParam query){
        HashMap param=query.getParam();
        String name= String.valueOf(param.get("name"));
        String rolename= String.valueOf(param.get("rolename"));
//        System.out.println("name=="+name+" ,rolename=="+rolename);
        Page<UserAndRole> page= new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name)&&!"null".equals(name)){
            lambdaQueryWrapper.like(User::getName,name);//eq完全匹配
        }

        if(StringUtils.isNotBlank(rolename)&&!"null".equals(rolename)){
            lambdaQueryWrapper.eq(User::getRolename,rolename);//eq完全匹配
        }

        IPage result =userService.pageCC(page,lambdaQueryWrapper);
//        System.out.println("result"+result.getRecords());
//        System.out.println("total=="+result.getTotal());

        return Result.suc(result.getRecords(),result.getTotal());
    }
}
