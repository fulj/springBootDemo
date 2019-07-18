package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author @author fulj on 2018/5/3 0003 下午 15:05
 * @version 1.0
 */
@Aspect //说明这个类是一个切面类
@Component
public class HttpAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    //切入点，在哪里干的集合 对比 JoinPoint的是目标对象的某一个复合表达式的方法
    @Pointcut("execution(public * com.example.demo.app.controller.*.*(..))")
//    @Pointcut("execution(public * com.trs.dataManagement.hybaseSearch.FullTableSearchController.*(..))")
    public void log(){

    }

    //通知，方法里面是我们的业务逻辑。参数JoinPoint
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={};ip:{}",request.getRequestURL(),request.getRemoteAddr());
        //method
//        LOGGER.info("method={}",request.getMethod());
        //ip
//        LOGGER.info("request_IP={}",request.getRemoteAddr());
        //class_method
//        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("request_args={}",joinPoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if(result == null){
            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
        LOGGER.info("response={}",object.toString());
    }
}
