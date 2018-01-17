package com.zeus.test.aspect;

import com.zeus.test.annotion.TimeMonitor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author keven
 * @date 2018-01-17 上午11:30
 * @Description
 */
@Component
@Aspect
public class TimeAspect {

    private static final Log LOG = LogFactory.getLog(TimeAspect.class);

    @Around("@annotation(timeMonitor)")
    public Object doAround(ProceedingJoinPoint joinPoint, TimeMonitor timeMonitor) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOG.error("+++++around " + joinPoint + "\t Use time : " + (end - start) + " ms!");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            LOG.error("+++++around " + joinPoint + "\t Use time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }

    }
}
