package com.suwei.spring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactoryBean;

/**我们来手动使用ProxyFactoryBean来创建Proxy对象，
 * 并将相应的几种不同的Advice加入这个proxy对应的各个执行阶段中：
 * Created by Administrator on 2017/8/22/022.
 * 通过ProxyFactoryBean 手动创建 代理对象
 */
public class App  {
    public static void main(String[] args) throws Exception {
        //1.针对不同的时期类型，提供不同的Advice
        Advice beforeAdvice = new TicketServiceBeforeAdvice();
        Advice afterReturningAdvice = new TicketServiceAfterReturningAdvice();
        Advice throwsAdvice = new TicketServiceThrowsAdvice();
        Advice aroundAdvice = new TicketServiceAroundAdvice();

        RailwayStation railwayStation = new RailwayStation();

        //2.创建ProxyFactoryBean，用于创建指定对象的Proxy对象
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

        //3.设置Proxy接口
        proxyFactoryBean.setInterfaces(TicketService.class);

        //4.设置RealSubject
        proxyFactoryBean.setTarget(railwayStation);

        //5.使用JDK基于接口实现机制的动态代理生成Proxy对象，如果要是使用CGLIB,需要将这个参数设置为true
        //proxyFactoryBean.setProxyTargetClass(true);

        //6.添加不同的Advice
        proxyFactoryBean.addAdvice(afterReturningAdvice);
        proxyFactoryBean.addAdvice(aroundAdvice);
        proxyFactoryBean.addAdvice(throwsAdvice);
        proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.setProxyTargetClass(false);
        //7.通过ProxyFactoryBean生成Proxy对象
        TicketService ticketService = (TicketService) proxyFactoryBean.getObject();
        ticketService.sellTicket();
    }
}
