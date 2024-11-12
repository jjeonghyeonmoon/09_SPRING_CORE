package com.ohgiraffers.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;

/*Aspect 어노테이션 : AOP 기능을 사용하기 위한 어노테이션
*   -Pointcut 과 Advice */
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.ohgiraffers.aop.*Service.*(..))")
    public void logPointCut() {
    }

    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before 타겟 정보 : " + joinPoint.getTarget());
        System.out.println("Before 타겟의 시그니처 : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("Before 타겟의 인자 :" + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After 타겟 정보 : " + joinPoint.getTarget());
        System.out.println("After 타겟의 시그니처 : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("After 타겟의 인자 :" + joinPoint.getArgs()[0]);
        }
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("result 변수에 Service 에서 return 되는 값이 담겻나? " + result);
        if (result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환되는 값 가공 성공!!!!"));
        }
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Around Before : " + joinPoint.getSignature().getName());

        // Target 메소드 실행
        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("Around After : " + joinPoint.getSignature().getName());
        System.out.println("메소드 실행에 소요 된 시간 : " + stopWatch.getTotalTimeMillis() + " ms");

        /*comment.
        *  조인 포인트를 호출한 쪽(지금은 Application)
        *  or 다른 어드바이스가 실행할 수 있도록 object 반환
        * */
        return result;
    }
}
