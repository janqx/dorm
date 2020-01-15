package cc.decat.dorm.dao.impl;

import cc.decat.dorm.dao.UserDao;
import cc.decat.dorm.util.DBUtil;
import cc.decat.dorm.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static Connection conn = DBUtil.getConn();

    /**
     *
     * @param user
     * @return 0: 添加成功、1：添加失败、-1：数据库错误
     */
    @Override
    public int add(User user) {

        int status = 0;
        String sql = "INSERT INTO user (username, password) VALUES(?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            status = ps.executeUpdate() == 1 ? 0 : 1;
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    /**
     *
     * @param user
     * @return 0：登陆成功、1：登陆失败，用户名或密码错误、-1：数据库异常
     * @throws SQLException
     */
    @Override
    public int login(User user) {

        int status = 0;
        String sql = "SELECT id FROM user WHERE username=? and password=? and identify=?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getIdentify());
            resultSet = ps.executeQuery();
            status = resultSet.next() ? 0 : 1;
        } catch(SQLException e) {
            status = -1;
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public List<User> getAllUser() {

        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String identify = resultSet.getString(4);
                userList.add(new User(id, username, password, identify));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 用户对象
     */
    @Override
    public User findUserByUserName(String username) {

        String sql = "SELECT * FROM user WHERE username=?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String identify = resultSet.getString(4);
                user = new User(id, name, password, identify);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
