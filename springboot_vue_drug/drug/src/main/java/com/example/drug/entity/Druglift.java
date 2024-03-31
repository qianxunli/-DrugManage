package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class Druglift extends Drug{
    private static final long serialVersionUID = 1L;
    @TableId(type= IdType.AUTO)
    private Integer drugid;

    private String drugname;

    private String drugaction;

    private String drugcontraindications;

    private BigDecimal drugbeforeprice;

    private BigDecimal drugnowprice;

    private LocalDate drugbirthday;

    private Integer drugshelflife;

    private String drugresidue;

    public String getDrugresidue() {
        return drugresidue;
    }

    public void setDrugresidue(String drugresidue) {
        this.drugresidue = drugresidue;
    }

    public Integer getdrugid() {
        return drugid;
    }

    public void setdrugid(Integer drugid) {
        this.drugid = drugid;
    }
    public String getdrugname() {
        return drugname;
    }

    public void setdrugname(String drugname) {
        this.drugname = drugname;
    }
    public String getdrugaction() {
        return drugaction;
    }

    public void setdrugaction(String drugaction) {
        this.drugaction = drugaction;
    }
    public String getdrugcontraindications() {
        return drugcontraindications;
    }

    public void setdrugcontraindications(String drugcontraindications) {
        this.drugcontraindications = drugcontraindications;
    }
    public BigDecimal getdrugbeforeprice() {
        return drugbeforeprice;
    }

    public void setdrugbeforeprice(BigDecimal drugbeforeprice) {
        this.drugbeforeprice = drugbeforeprice;
    }
    public BigDecimal getdrugnowprice() {
        return drugnowprice;
    }

    public void setdrugnowprice(BigDecimal drugnowprice) {
        this.drugnowprice = drugnowprice;
    }
    public LocalDate getdrugbirthday() {
        return drugbirthday;
    }

    public void setdrugbirthday(LocalDate drugbirthday) {
        this.drugbirthday = drugbirthday;
    }
    public Integer getdrugshelflife() {
        return drugshelflife;
    }

    public void setdrugshelflife(Integer drugshelflife) {
        this.drugshelflife = drugshelflife;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugid=" + drugid +
                ", drugname=" + drugname +
                ", drugaction=" + drugaction +
                ", drugcontraindications=" + drugcontraindications +
                ", drugbeforeprice=" + drugbeforeprice +
                ", drugnowprice=" + drugnowprice +
                ", drugbirthday=" + drugbirthday +
                ", drugshelflife=" + drugshelflife +
                "}";
    }
}
