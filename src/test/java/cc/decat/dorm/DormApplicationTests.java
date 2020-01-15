package cc.decat.dorm;

import cc.decat.dorm.mapper.DormMapper;
import cc.decat.dorm.mapper.UserMapper;
import cc.decat.dorm.model.Dorm;
import cc.decat.dorm.model.User;
import cc.decat.dorm.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DormApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {

        System.out.println("HelloWorld!!!");
    }

}
