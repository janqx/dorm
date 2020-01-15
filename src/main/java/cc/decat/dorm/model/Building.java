package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//楼房
public class Building {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
    private Integer maxNumber; //可住人数
    private Integer currentNumber; //已住人数
    private String adminUserName; //宿管用户名
}
