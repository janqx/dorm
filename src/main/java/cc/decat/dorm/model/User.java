package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String identify;

    public User() {

    }

    public User(String username, String password, String identify) {
        this.username = username;
        this.password = password;
        this.identify = identify;
    }

    public User(Integer id, String username, String password, String identify) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.identify = identify;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identify='" + identify + '\'' +
                '}';
    }
}
