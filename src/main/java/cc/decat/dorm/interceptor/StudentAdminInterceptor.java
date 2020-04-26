package cc.decat.dorm.interceptor;

import cc.decat.dorm.model.Student;
import cc.decat.dorm.model.User;
import cc.decat.dorm.service.StudentService;
import cc.decat.dorm.session.SessionMap;
import cc.decat.dorm.util.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class StudentAdminInterceptor extends HandlerInterceptorAdapter {

    private Map<String, User> userMap = SessionMap.get("user");
    private Map<String, Student> studentMap = SessionMap.get("student");

    @Resource
    private StudentService studentService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionID = CookieUtil.getCookieValue(request.getCookies(), "sessionID");
        User user = userMap.get(sessionID);
        if(user.getIdentify().equalsIgnoreCase("student")) {
            Student student = studentService.getStudentByUserName(user.getUsername());
            if(student != null) {
                studentMap.put(sessionID, student);
                return super.preHandle(request, response, handler);
            }
        }
        response.sendRedirect("/login");
        return false;
    }
}
