package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item extends Orderitem{

    private Integer orderitemid;

    private Integer drugnum;

    private BigDecimal drugprice;

    private Integer drugid;

    private String drugname;

    private Integer userid;

    private Integer orderformid;

    public Item(Orderitem orderitem){
        this.drugid=orderitem.getDrugid();
        this.orderitemid=orderitem.getOrderitemid();
        this.drugnum=orderitem.getDrugnum();
        this.orderformid=orderitem.getOrderformid();
        this.userid=orderitem.getUserid();
        this.drugprice=orderitem.getDrugprice();
    }

    public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public Integer getDrugnum() {
        return drugnum;
    }

    public void setDrugnum(Integer drugnum) {
        this.drugnum = drugnum;
    }

    public BigDecimal getDrugprice() {
        return drugprice;
    }

    public void setDrugprice(BigDecimal drugprice) {
        this.drugprice = drugprice;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }
}
