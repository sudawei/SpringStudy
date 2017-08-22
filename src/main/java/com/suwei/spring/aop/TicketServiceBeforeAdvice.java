package com.suwei.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/8/22/022.
 * 执行RealSubject对象的方法之前的处理意见
 */
public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {
   
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BEFORE_ADVICE: 欢迎光临代售点....");
    }
}
