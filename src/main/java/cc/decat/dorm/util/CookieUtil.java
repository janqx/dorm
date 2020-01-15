package cc.decat.dorm.util;

import javax.servlet.http.Cookie;

public class CookieUtil {

    public static String getCookieValue(Cookie[] cookies, String name) {

        if(cookies == null || name == null) {
            return null;
        }
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
