package com.paramonga.ssff.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class EnvInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest req, HttpServletResponse res, Object handler) {
        String env = req.getParameter("env");
        if (env != null) {
            EnvironmentContextHolder.setEnv(env);
        }
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) {
        EnvironmentContextHolder.clear();
    }
}