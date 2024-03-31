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
public class Shoptrolley implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer shoptrolleyid;

    private Integer userid;

    private Integer drugid;



    private Integer drugrepertoryid;

    private Integer drugnum;
    private BigDecimal drugprice;
    private String drugname;
    public Integer getDrugrepertoryid() {
        return drugrepertoryid;
    }

    public void setDrugrepertoryid(Integer drugrepertoryid) {
        this.drugrepertoryid = drugrepertoryid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public Integer getShoptrolleyid() {
        return shoptrolleyid;
    }

    public void setShoptrolleyid(Integer shoptrolleyid) {
        this.shoptrolleyid = shoptrolleyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
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



    @Override
    public String toString() {
        return "Shoptrolley{" +
                "shoptrolleyid=" + shoptrolleyid +
                ", userid=" + userid +
                ", drugid=" + drugid +
                ", drugnum=" + drugnum +
                ", drugname='" + drugname + '\'' +
                ", drugprice=" + drugprice +
                '}';
    }
}
