package cc.decat.dorm.interceptor;

import cc.decat.dorm.model.User;
import cc.decat.dorm.service.UserService;
import cc.decat.dorm.session.SessionMap;
import cc.decat.dorm.util.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class UserLoginInterceptor extends HandlerInterceptorAdapter  {

    @Resource
    private UserService userService;

    private Map<String, User> userMap = SessionMap.get("user");

    // 登陆验证
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getMethod() + ":\t" + request.getRequestURL());
        String sessionID = CookieUtil.getCookieValue(request.getCookies(), "sessionID");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);

        if(!StringUtils.isEmpty(sessionID)) {
            Object obj = userMap.get(sessionID);
            if(obj != null && obj instanceof User) {
                User user = (User)obj;
                if(userService.login(user)) {
                    System.out.println("登陆拦截 通过。。");
                    return super.preHandle(request, response, handler);
                }
            }
        }
        response.sendRedirect("/login");
        return false;
    }
}
