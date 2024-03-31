package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Repertory extends Drugrepertory{

    private Integer drugrepertoryid;

    private Integer drugid;

    private Integer drugnum;

    private LocalDate drugtimeremain;
    private LocalDate drugbirthday;

    private Integer drugshelflife;
    private Integer state;
    private BigDecimal drugbeforeprice;

    private BigDecimal drugnowprice;

    public BigDecimal getDrugbeforeprice() {
        return drugbeforeprice;
    }

    public void setDrugbeforeprice(BigDecimal drugbeforeprice) {
        this.drugbeforeprice = drugbeforeprice;
    }

    public BigDecimal getDrugnowprice() {
        return drugnowprice;
    }

    public void setDrugnowprice(BigDecimal drugnowprice) {
        this.drugnowprice = drugnowprice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDate getDrugbirthday() {
        return drugbirthday;
    }

    public void setDrugbirthday(LocalDate drugbirthday) {
        this.drugbirthday = drugbirthday;
    }

    public Integer getDrugshelflife() {
        return drugshelflife;
    }

    public void setDrugshelflife(Integer drugshelflife) {
        this.drugshelflife = drugshelflife;
    }

    private String drugname;
    private String drugresidue;

    public String getDrugresidue() {
        return drugresidue;
    }

    public void setDrugresidue(String drugresidue) {
        this.drugresidue = drugresidue;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public Integer getDrugrepertoryid() {
        return drugrepertoryid;
    }

    public void setDrugrepertoryid(Integer drugrepertoryid) {
        this.drugrepertoryid = drugrepertoryid;
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

    public LocalDate getDrugtimeremain() {
        return drugtimeremain;
    }

    public void setDrugtimeremain(LocalDate drugtimeremain) {
        this.drugtimeremain = drugtimeremain;
    }
}
