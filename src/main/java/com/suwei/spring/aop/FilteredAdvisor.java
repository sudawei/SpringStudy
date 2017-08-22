package com.suwei.spring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * Created by Administrator on 2017/8/22/022.
 */
public class FilteredAdvisor implements PointcutAdvisor {
    private Pointcut pointcut;
    private Advice advice;

    public FilteredAdvisor(Pointcut pointcut, Advice advice) {
        this.pointcut = pointcut;
        this.advice = advice;
    }
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    public Advice getAdvice() {
        return this.advice;
    }

    public boolean isPerInstance() {
        return false;
    }
}
