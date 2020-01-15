package cc.decat.dorm.service;

import cc.decat.dorm.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {

    public boolean login(User user);
    public User login(String username, String password, String identify);
    public boolean register(User user);
    public User findUserByUserName(String username);
}