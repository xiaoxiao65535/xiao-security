package com.xiao.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 〈时间过滤器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 10:06
 * @since 1.0.0
 */
//@Component 这样配置会拦截所有
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter 开始执行");
        long start = System.currentTimeMillis();
        // Filter 不能了解到具体是哪个Controller的那个方法处理的请求。
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("TimeFilter 执行时间了" + (System.currentTimeMillis() - start) + "毫秒");
        System.out.println("TimeFilter 结束执行");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter 销毁");
    }
}
