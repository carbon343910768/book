package com.bjtuxxq.demo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName = "userTypeFilter", urlPatterns = "/**")
public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponseFilterChain, FilterChain filterChain) throws IOException, ServletException{

    }
}
