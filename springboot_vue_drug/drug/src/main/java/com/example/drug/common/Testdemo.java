package com.example.drug.common;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

public class Testdemo {


    // 省略其他属性和方法

    // 计算保质期剩余时间的方法
    public String calculateRemainingShelfLife(LocalDate drugbirthday,Integer drugshelflife) {
        LocalDate today = LocalDate.now();
        System.out.println("to"+today);
        LocalDate expirationDate = drugbirthday.plusMonths(drugshelflife);
        System.out.println("ex"+expirationDate);

        // 使用Period计算两个日期之间的差距
        Period period = Period.between(today, expirationDate);
        int year=period.getYears();
        int remainingMonths = period.getMonths();
        int remainingDays = period.getDays();
        System.out.println("sou"+period);
        return String.format("%d个年%d个月%d天", year,remainingMonths, remainingDays);
    }

    @Test
    public  void test() {
        Testdemo drug = new Testdemo();
        LocalDate drugbirthday = LocalDate.of(2020, 2, 1);;
        Integer drugshelflife=24;

        String remainingTime = drug.calculateRemainingShelfLife(drugbirthday,drugshelflife);
        System.out.println("保质期剩余时间：" + remainingTime);
    }
}
