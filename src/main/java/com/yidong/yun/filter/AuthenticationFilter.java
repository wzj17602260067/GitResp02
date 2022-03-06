package com.yidong.yun.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

//@Order(Ordered.HIGHEST_PRECEDENCE)
//@Component
public class AuthenticationFilter implements Filter {


    public static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
