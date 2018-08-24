package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Desiom on 2018/6/6.
 */
@Aspect
@Component
public class HttpAspect {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class );


    //http请求到其他controler的接口时就完成逻辑判断
    //指定单一接口girlList()
//    @Before("execution(public * com.spring.controller.GirlController.girlList(..))")
    //指定GirlController的全部接口

//    @Before("execution(public * com.spring.controller.GirlController.*(..))")
//    public void log1(){
//        System.err.println("test start");
//    }
//
//    @After("execution(public * com.spring.controller.GirlController.*(..))")
//    public void after1(){
//        System.err.println("test end");
//    }

    //对上述两种方法进行优化（不显示注解中的重复代码部分）
    //定义一个公用日志方法，使用注解Pointcut——面向切面编程
    @Pointcut("execution(public * com.spring.controller.*.*(..))")
    public void log2(){
    }

    //注解内部调用公用方法
    @Before("log2()")
    public void begin2(JoinPoint joinPoint){
//        System.err.println("test start");
        logger.info("test start");
        //记录http请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        //joinPoint.getSignature().getDeclaringTypeName()):获取类名
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //params
        logger.info("args={}",joinPoint.getArgs());
    }

    //注解内部调用公用方法
    @After("log2()")
    public void after2(){
//        System.err.println("test end");
        logger.info("test end");
    }

    //获取返回的内容
    @AfterReturning(returning = "object",pointcut = "log2()")
    public void afterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
