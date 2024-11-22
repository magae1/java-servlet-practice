package com.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MyFilter implements Filter {

    FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
        String filterName = filterConfig.getFilterName();
        System.out.println("MyFilter -> init() 호출됨: " + filterName);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String filterInitParam = config.getInitParameter("FilterInitParam");
        System.out.println("MyFilter -> 필터 초기 변수(web.xml) : " + filterInitParam);

        String method = ((HttpServletRequest) request).getMethod();
        System.out.println("MyFilter -> 전송방식 : " + method);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter -> destroy() 호출됨");
    }
}
