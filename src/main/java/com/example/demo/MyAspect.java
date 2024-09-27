package com.example.demo;

/* AOC */
//Aspect-Oriented Programming 切面導向程式設計

/* @Aspect */
//加在class上(需和@Component一起使用)
//宣告這個class是一個切面

/* @Before */
//加在切面Class方法上
//在切入點的方法執行前執行

/* @After */
//加在切面Class的方法上
//在切入點的方法執行後執行

/* @Around */
//加在切面Class的方法上
//在切入點的方法執行前、後執行

//不常用
//@AfterThrowing:在切入點的方法拋出異常後執行
//@AfterReturning:在切入點的方法執行成功後執行

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {


    //    @Before("execution(* com.example.demo.HpPrinter.*(..))")
//    這是切入點，描述Hp printer裡的所有方法
//    代表在執行Hp printer裡的方法前先執行這個方法
    public void before() {
        System.out.println("I'm before");
    }

    //    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after() {
        System.out.println("I'm after");
    }

    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I'm around before");
        Date start = new Date();
        Object obj = pjp.proceed();
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("I'm around after");
        System.out.println("共執行了: " + time + "ms");
        return obj;
    }
}
