package com.krokodillLl.random.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* com.krokodillLl.random.controllers.*.*(..))")
    public Object controllersLogging(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("can't executed " + proceedingJoinPoint.getSignature().getName());
            return null;
        }
        long end = System.currentTimeMillis();
        logger.info("executed request for: " + proceedingJoinPoint.getSignature().toShortString() +
                " in " + ((double) ((end - start)) / 1000) + " sec");
        return result;
    }
}
