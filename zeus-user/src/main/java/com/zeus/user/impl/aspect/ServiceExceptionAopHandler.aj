package com.zeus.user.impl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author keven
 * @date 2018-02-10 下午4:15
 * @Description
 */
@Component
@Aspect
public class ServiceExceptionAopHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.zeus.user.impl..*.*(..))")
    public Object serviceExceptionInterceptor(ProceedingJoinPoint joinPoint)
            throws Throwable {
        try {
            logger.info("The method " + joinPoint.getSignature().getName()
                    + "() begins with " + Arrays.toString(joinPoint.getArgs()));

            Object result = joinPoint.proceed();

            logger.info("The method " + joinPoint.getSignature().getName()
                    + "() ends with " + result);

            return result;
        } catch (Exception e) {// 捕获参数异常
            throw new Exception("");
        }
    }
}