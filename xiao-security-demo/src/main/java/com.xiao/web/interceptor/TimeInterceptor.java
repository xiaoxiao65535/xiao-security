package com.xiao.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈时间拦截器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 10:23
 * @since 1.0.0
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    // 处理请求之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("time interceptor preHandle");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取处理请求的类
        System.out.println(handlerMethod.getBean().getClass().getName());
        // 获取处理请求的方法 能拿到信息，不能拿到参数值
        System.out.println(handlerMethod.getMethod().getName());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    // 处理请求过程中
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor postHandle");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时 ：" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        // 不管正常返回还是有异常，都会执行这里哦
        System.out.println("time interceptor afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时 ：" + (System.currentTimeMillis() - start));
        System.out.println("ex is " + e);
    }
}
