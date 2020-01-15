package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

// 宿管
public class DormAdmin {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String name;
    private Integer age;
    private Integer sex;
    private String phoneNumber;
    private Date hiredate;//入职时间
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
}
