package cc.decat.dorm.controller;

import cc.decat.dorm.model.User;
import cc.decat.dorm.service.UserService;
import cc.decat.dorm.service.impl.UserServiceImpl;
import cc.decat.dorm.session.SessionMap;
import cc.decat.dorm.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class homeController {

    @Resource
    private UserService userService;

    private static Map<String, User> userMap = SessionMap.get("user");

    @GetMapping({"/", "/index"})
    public String index(
            @CookieValue(value = "sessionID", required = false) String sessionID) {

        System.out.println("sessionId:\t" + sessionID);
        if(!StringUtils.isEmpty(sessionID)) {
            Object obj = userMap.get(sessionID);
            if(obj != null && obj instanceof User) {
                User user = (User)obj;
                System.out.println("验证成功。");
                System.out.println(user);
                return "redirect:/user/admin";
            }
        }
        return "login";
    }
}