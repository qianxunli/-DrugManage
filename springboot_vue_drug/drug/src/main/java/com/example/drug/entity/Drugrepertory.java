package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianxun
 * @since 2023-12-17
 */
@Data
public class Drugrepertory implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type= IdType.AUTO)
    private Integer drugrepertoryid;

    private Integer drugid;

    private Integer drugnum;

    private LocalDate drugtimeremain;

    public Drugrepertory() {
    }

    public Drugrepertory(Repertory repertory) {
        this.drugrepertoryid = repertory.getDrugrepertoryid();
        this.drugid = repertory.getDrugid();
        this.drugnum = repertory.getDrugnum();
        this.drugtimeremain = repertory.getDrugtimeremain();
    }
}
