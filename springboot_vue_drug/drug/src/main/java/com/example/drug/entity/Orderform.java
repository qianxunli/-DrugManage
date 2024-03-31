package com.example.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianxun
 * @since 2023-12-18
 */
public class Orderform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer orderformid;

    private Integer ordernumber;

    private Integer userid;

    private String acceptaddress;

    private String telephone;

    private LocalDate orderformcreatetime;

    @Override
    public String toString() {
        return "Orderform{" +
                "orderformid=" + orderformid +
                ", ordernumber=" + ordernumber +
                ", userid=" + userid +
                ", acceptaddress='" + acceptaddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orderformcreatetime=" + orderformcreatetime +
                ", orderformdelivergoodtime=" + orderformdelivergoodtime +
                ", orderformstate='" + orderformstate + '\'' +
                '}';
    }

    private LocalDate orderformdelivergoodtime;//发货

    public Integer getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAcceptaddress() {
        return acceptaddress;
    }

    public void setAcceptaddress(String acceptaddress) {
        this.acceptaddress = acceptaddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getOrderformcreatetime() {
        return orderformcreatetime;
    }

    public void setOrderformcreatetime(LocalDate orderformcreatetime) {
        this.orderformcreatetime = orderformcreatetime;
    }

    public LocalDate getOrderformdelivergoodtime() {
        return orderformdelivergoodtime;
    }

    public void setOrderformdelivergoodtime(LocalDate orderformdelivergoodtime) {
        this.orderformdelivergoodtime = orderformdelivergoodtime;
    }

    public String getOrderformstate() {
        return orderformstate;
    }

    public void setOrderformstate(String orderformstate) {
        this.orderformstate = orderformstate;
    }

    private String orderformstate;


}
