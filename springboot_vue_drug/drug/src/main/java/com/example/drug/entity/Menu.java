package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianxun
 * @since 2023-12-16
 */
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer menuid;

    /**
     * 菜单编码
     */
    private String menucode;

    /**
     * 菜单名字
     */
    private String menuname;

    /**
     * 菜单级别
     */
    private String menulevel;

    /**
     * 菜单的父code
     */
    private String menuparentcode;

    /**
     * 点击触发的函数
     */
    private String menuclick;

    /**
     * 权限 0管理员，1表示员工 2表示用户
     */
    private String menuright;

    private String menucomponent;

    private String menuicon;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(String menulevel) {
        this.menulevel = menulevel;
    }

    public String getMenuparentcode() {
        return menuparentcode;
    }

    public void setMenuparentcode(String menuparentcode) {
        this.menuparentcode = menuparentcode;
    }

    public String getMenuclick() {
        return menuclick;
    }

    public void setMenuclick(String menuclick) {
        this.menuclick = menuclick;
    }

    public String getMenuright() {
        return menuright;
    }

    public void setMenuright(String menuright) {
        this.menuright = menuright;
    }

    public String getMenucomponent() {
        return menucomponent;
    }

    public void setMenucomponent(String menucomponent) {
        this.menucomponent = menucomponent;
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon;
    }
}
