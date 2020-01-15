package cc.decat.dorm.session;

import cc.decat.dorm.model.Student;
import cc.decat.dorm.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class SessionMap {

//    private static Map<String, Object> sessionMap = new Hashtable<>();
    private static Map<String, Map> sessionMap = new HashMap<>();

    static {
        sessionMap.put("user", new Hashtable<String, User>());
        sessionMap.put("student", new Hashtable<String, Student>());
//        sessionMap.put("sessionID", new Hashtable());
    }

    public static Map get(String key) {
        return sessionMap.get(key);
    }
}
