package com.ohgiraffers.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfig.class);

        MemberService memberService
                = context.getBean("memberService", MemberService.class);

        System.out.println("================selectMembers================");
        System.out.println(memberService.selectMembers());
        System.out.println("================selectMember===================");
        System.out.println(memberService.selectMember(1L));
    }


    /* comment.
     *   @AfterThrowing
     * */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("AfterThrowing exception = " + exception);
    }
}