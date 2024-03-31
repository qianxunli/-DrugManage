package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianxun
 * @since 2023-12-12
 */
@Data
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer userroleid;


    private Integer userid;


    private Integer roleid;

    public Integer getUserRoleId() {
        return userroleid;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userroleid = userRoleId;
    }
    public Integer getUserId() {
        return userid;
    }

    public void setUserId(Integer userId) {
        this.userid = userId;
    }
    public Integer getRoleId() {
        return roleid;
    }

    public void setRoleId(Integer roleId) {
        this.roleid = roleId;
    }

    @Override
    public String toString() {
        return "Userrole{" +
            "userRoleId=" + userroleid +
            ", userId=" + userid +
            ", roleId=" + roleid +
        "}";
    }
}
