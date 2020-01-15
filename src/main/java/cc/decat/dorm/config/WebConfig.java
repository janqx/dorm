package cc.decat.dorm.config;

import cc.decat.dorm.interceptor.AccessInterceptor;
import cc.decat.dorm.interceptor.StudentAdminInterceptor;
import cc.decat.dorm.interceptor.UserLoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Resource
    private UserLoginInterceptor userLoginInterceptor;

    @Resource
    private StudentAdminInterceptor studentAdminInterceptor;

    @Resource
    private AccessInterceptor accessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/*/**");
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/user/admin/**");
        registry.addInterceptor(studentAdminInterceptor).addPathPatterns("/user/admin/student/**");
    }
}
