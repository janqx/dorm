package cc.decat.dorm.controller.insidetemplatecontroller;

import cc.decat.dorm.model.Student;
import cc.decat.dorm.model.User;
import cc.decat.dorm.service.StudentService;
import cc.decat.dorm.service.UserService;
import cc.decat.dorm.session.SessionMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class StudentInsideTemplateController {

    private final static String rootPath = "/user/admin/insidetemplates/student";

    private Map<String, Student> studentMap = SessionMap.get("student");
    private Map<String, User> userMap = SessionMap.get("user");

    @Resource
    private StudentService studentService;

    @Resource
    private UserService userService;

    @GetMapping("/user/admin/student")
    public String studentAdmin(Model model, @CookieValue(value = "sessionID", required = false) String sessionID) {

        Student student = studentMap.get(sessionID);
        System.out.println(student);
        model.addAttribute("student", student);
        return "admin/student";
    }

    @GetMapping(rootPath + "/dorminfo")
    public String dormInfo(Model model,
                           @CookieValue(value = "sessionID", required = false) String sessionID) {

        Student student = studentMap.get(sessionID);
        String dorminfo = "地址：" + student.getFlatsName() + "-" + student.getBuildingNumber() + "栋，宿舍号：" + student.getDormNumber() + "。";
        model.addAttribute("dorminfo", dorminfo);
        return "admin/insidetemplates/student/dorminfo";
    }

    @PostMapping("/user/admin/student/dorminfo")
    @ResponseBody
    public List<Map<String, String>> dormInfoSubmit(@CookieValue(value = "sessionID", required = false) String sessionID) {
        Student student = studentMap.get(sessionID);
        List<Map<String, String>> result = new ArrayList<>();
        int i = 1;
        for (Student s : studentService.findStudentListByDormNumber(student.getFlatsName(), student.getBuildingNumber(), student.getDormNumber())) {
            Map<String, String> studentMap = new HashMap<>();
            studentMap.put("id", (i++)+"");
            studentMap.put("name", s.getName());
            studentMap.put("phonenumber", s.getPhoneNumber());
            studentMap.put("college", s.getCollege());
            studentMap.put("grade", s.getGrade());
            studentMap.put("specialty", s.getSpecialty());
            studentMap.put("classes", s.getClasses());
            studentMap.put("indate", s.getInDate().toString());
            result.add(studentMap);
        }
        return result;
    }

    @GetMapping(rootPath + "/setmyinfo")
    public String setmyInfo(Model model,
                            @CookieValue(value = "sessionID", required = false) String sessionID) {

        Student student = studentMap.get(sessionID);
        model.addAttribute("student", student);
        return "admin/insidetemplates/student/setmyinfo";
    }

    @GetMapping(rootPath + "/absence")
    public String absence() {
        return "admin/insidetemplates/student/absence";
    }

    @GetMapping(rootPath + "/setmypassword")
    public String setmypassword() {
        return "admin/insidetemplates/student/setmypassword";
    }

    @PostMapping("/user/admin/student/setmypassword")
    @ResponseBody
    public Map<String, String> setmypasswordSubmit(
            @CookieValue(value = "sessionID", required = false) String sessionID,
            @RequestParam(value = "oldpassword", required = false) String oldpassword,
            @RequestParam(value = "password", required = false) String password) {

        Map<String, String> result = new HashMap<>();
        result.put("msg", "未知错误!");
        result.put("icon", "2");
        Student student = studentMap.get(sessionID);
        User user = userService.findUserByUserName(student.getUsername());

        if(user.getPassword().equalsIgnoreCase(oldpassword)) {
            user.setPassword(password);
            if(userService.updateById(user)) {
                result.put("msg", "修改成功~");
                result.put("icon", "1");
                userMap.put(sessionID, user);
            }
        } else {
            result.put("msg", "密码错误!");
            result.put("icon", "2");
        }
        return result;
    }
}
