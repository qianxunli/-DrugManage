package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianxun
 * @since 2023-12-18
 */
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer orderitemid;

    private Integer drugnum;

    private BigDecimal drugprice;

    private Integer drugid;

    private Integer userid;

    private Integer orderformid;

    @Override
    public String toString() {
        return "Orderitem{" +
                "orderitemid=" + orderitemid +
                ", drugnum=" + drugnum +
                ", drugprice=" + drugprice +
                ", drugid=" + drugid +
                ", userid=" + userid +
                ", orderformid=" + orderformid +
                '}';
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
