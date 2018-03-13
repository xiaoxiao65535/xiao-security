package com.xiao.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 〈时间切片〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 11:09
 * @since 1.0.0
 */
@Aspect
@Component
public class TimeAspect {

    /**
     * * execution(* com.xiao.web.controller.UserController.*(..))
     * execution执行com.xiao.web.controller.UserController的任意参数
     * ，包含任意参数，返回任何返回值。
     * 具体看示例 https://docs.spring.io/spring/docs/4.3.14.RELEASE/spring-framework-reference/htmlsingle/#aop-pointcuts-examples
     */
    @Around("execution(* com.xiao.web.controller.UserController.getCurrentUser(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // joinPoint包含拦截的方法所有信息
        System.out.println("time Aspect 开始");

        long start = System.currentTimeMillis();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        // 真正执行方法
        Object obj = joinPoint.proceed();

        System.out.println("time Aspect 耗时：" + (System.currentTimeMillis() - start));

        System.out.println("time Aspect 结束");
        return obj;
    }

}
