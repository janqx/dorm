package cc.decat.dorm.dao;

import cc.decat.dorm.model.User;

import java.util.List;

public interface UserDao {

    public int add(User user);//添加一个用户
    public int login(User user); //通过用户名、密码、身份登陆
    public List<User> getAllUser(); //获取全部用户
    public User findUserByUserName(String username); //通过用户名获取用户对象

}
