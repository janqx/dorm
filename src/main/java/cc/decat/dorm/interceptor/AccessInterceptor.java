package cc.decat.dorm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=CAO PSA OUR");
        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
            response.addHeader("Access-Control-Max-Age", "120");
        }
        return true;
    }
}
