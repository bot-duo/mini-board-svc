package kr.co.miniboard.application.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gjlee
 * @desc Authentication Interceptor
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Value("${spring.profiles.active}")
    private String PROFILE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String accessUrl = request.getRequestURL().toString();      // 접근 URL
        String userAgent = request.getHeader("User-Agent");         // User-Agent

        if (null != request.getQueryString()) {
            accessUrl += "?" + request.getQueryString();
        }

        log.info("##################################################");
        log.info("# Access URL: {}", accessUrl);
        log.info("# User-Agent: {}", userAgent);

        if ("local".equals(PROFILE)) {
            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
    }
}