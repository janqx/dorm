package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

//快件记录
public class Express {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
    private String name;//快件名字
    private Date getDate;//收件日期
    private String studentNumber;// 领取学生的学号
}
