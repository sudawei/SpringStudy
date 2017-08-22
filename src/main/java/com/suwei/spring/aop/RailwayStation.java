package com.suwei.spring.aop;

/**
 * Created by Administrator on 2017/8/22/022.
 * RailwayStation实现售票服务
 */
public class RailwayStation implements TicketService {

    public void sellTicket(){
        System.out.println("售票............");
    }

    public void inQuire(){
        System.out.println("问询.............");
    }

    public void withDrow(){
        System.out.println("退票.............");
    }
}
