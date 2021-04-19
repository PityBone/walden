package com.oops.walden.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: LiJinHu
 * @Description:
 * @Date: Create in 10:52 2021/4/18
 */
@Component
@Aspect
public class APIProxy {

    @Pointcut("@annotation(com.oops.walden.annotation.RecordLog)")
    public void doAspect(){

    }

    @Around("doAspect()")
    public Object around(ProceedingJoinPoint point){
        System.out.println("方法前============");
        Object[] args = point.getArgs();
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        System.out.println(strClassName);
        System.out.println(strMethodName);
        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    @Before("doAspect()")
    public Object before(ProceedingJoinPoint point){
        System.out.println("方法前============");
        Object[] args = point.getArgs();
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        System.out.println(strClassName);
        System.out.println(strMethodName);
        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
