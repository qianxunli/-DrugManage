package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserAndRole extends User{
    private Integer userid;

    private String userName;

    private String password;

    private String name;

    private LocalDate birthday;

    private String telephone;

    private String address;

    private String rolename;
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
