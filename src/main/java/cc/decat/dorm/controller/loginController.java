package cc.decat.dorm.controller;

import cc.decat.dorm.model.User;
import cc.decat.dorm.service.UserService;
import cc.decat.dorm.service.impl.UserServiceImpl;
import cc.decat.dorm.session.SessionMap;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

@Controller
public class loginController {

    @Resource
    private UserService userService;

    private static Map<String, User> userMap = SessionMap.get("user");

    @PostMapping("/user/login")
    public String loginSubmit(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "identify", required = false) String identify,
            HttpServletResponse response) {

        User user = userService.login(username, password, identify);
        System.out.println(user);
        if(user != null) {
            String sessionID = UUID.randomUUID().toString();
            userMap.put(sessionID, user);
            Cookie sessIdCook = new Cookie("sessionID", sessionID);
            sessIdCook.setPath("/");
            sessIdCook.setMaxAge(7 * 24 * 60 * 60); //设置Cookie保存时间为7天
            response.addCookie(sessIdCook);
            return "redirect:/user/admin";
        } else {
            return "login";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
