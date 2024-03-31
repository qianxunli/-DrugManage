package com.example.drug.entity;

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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer roleid;

    @TableField("rolename")
    private String roleName;


    public Integer getRoleId() {
        return roleid;
    }

    public void setRoleId(Integer roleId) {
        this.roleid = roleId;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
            "roleId=" + roleid +
            ", roleName=" + roleName +
        "}";
    }
}
