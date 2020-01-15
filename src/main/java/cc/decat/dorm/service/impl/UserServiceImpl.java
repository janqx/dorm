package cc.decat.dorm.service.impl;

import cc.decat.dorm.mapper.UserMapper;
import cc.decat.dorm.model.User;
import cc.decat.dorm.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {

        if(user == null || user.getUsername() == null || user.getPassword() == null || user.getIdentify() == null) {
            return false;
        }
        return userMapper.selectOne(
                new QueryWrapper<User>().
                        eq("username", user.getUsername()).
                        eq("password", user.getPassword()).
                        eq("identify", user.getIdentify())
        ) != null;
    }

    @Override
    public User login(String username, String password, String identify) {
        return userMapper.selectOne(
                new QueryWrapper<User>()
                        .eq("username", username)
                        .eq("password", password)
                        .eq("identify", identify)
        );
    }

    @Override
    public boolean register(User user) {

        if(user == null || user.getUsername() == null || user.getPassword() == null || user.getIdentify() == null) {
            return false;
        }
        return this.save(user);
    }

    @Override
    public User findUserByUserName(String username) {

        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }
}
