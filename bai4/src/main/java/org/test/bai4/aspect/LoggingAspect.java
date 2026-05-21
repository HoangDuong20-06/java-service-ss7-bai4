package org.test.bai4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @AfterThrowing(pointcut = "execution(* org.test.bai4.aspect.*.*(..))", throwing = "error")
    public void logSystemError(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println(">>> [NỘI BỘ HỆ THỐNG - AUDIT LOG LOGGING]");
        System.out.println("Lỗi xảy ra tại hàm: " + methodName);
        System.out.println("Chi tiết lỗi (StackTrace): " + error.getMessage());
    }
}
