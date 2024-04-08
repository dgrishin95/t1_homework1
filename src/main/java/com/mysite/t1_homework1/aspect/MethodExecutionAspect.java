package com.mysite.t1_homework1.aspect;

import com.mysite.t1_homework1.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class MethodExecutionAspect {

    private final TimeTrackingService timeTrackingService;

    @Around("@annotation(com.mysite.t1_homework1.annotation.TrackTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        timeTrackingService.saveExecutionTime("not-async", joinPoint.getSignature().toShortString(), executionTime);
        return proceed;
    }

    @Around("@annotation(com.mysite.t1_homework1.annotation.TrackAsyncTime)")
    public Object trackAsyncTime(ProceedingJoinPoint joinPoint) throws Throwable {
        return CompletableFuture.runAsync(() -> {
            try {
                long startTime = System.currentTimeMillis();
                joinPoint.proceed();
                long executionTime = System.currentTimeMillis() - startTime;
                timeTrackingService.saveExecutionTime("async", joinPoint.getSignature().toShortString(), executionTime);
            } catch (Throwable e) {
                log.error("Error", e);
            }
        });
    }
}
