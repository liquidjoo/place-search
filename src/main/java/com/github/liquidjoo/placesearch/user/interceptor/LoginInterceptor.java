package com.github.liquidjoo.placesearch.user.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        final Object user = httpSession.getAttribute("user");
        if (Objects.isNull(user)) {
            logger.info("redirect login page");
            response.sendRedirect("/login");
        }
        return super.preHandle(request, response, handler);
    }
}
