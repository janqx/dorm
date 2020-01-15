package cc.decat.dorm.controller;

import cc.decat.dorm.model.User;
import cc.decat.dorm.session.SessionMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AdminController {

    private static Map<String, User> userMap = SessionMap.get("user");

    @GetMapping("/user/admin")
    public String adminHome(@CookieValue(value = "sessionID", required = false) String sessionID) {
        User user = userMap.get(sessionID);
        System.out.println("user/admin...");
        return "redirect:/user/admin/" + user.getIdentify();
    }
}
