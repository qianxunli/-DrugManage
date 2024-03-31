package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.Period;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianxun
 * @since 2023-12-09
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    //@TableField("userid")
    private Integer userid;

    @TableField("username")
    private String userName;

    private String password;

    private String name;

    private LocalDate birthday;

    private String telephone;

    private String address;
    private String rolename;
   public User(){

   }

    public User(UserAndRole userAndRole) {
        this.userid=userAndRole.getUserid();
        this.userName = userAndRole.getUserName();
        this.password = userAndRole.getPassword();
        this.name = userAndRole.getName();
        this.birthday = userAndRole.getBirthday();
        this.telephone = userAndRole.getTelephone();
        this.address = userAndRole.getAddress();
    }



}
