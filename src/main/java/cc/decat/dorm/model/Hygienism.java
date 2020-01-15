package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

// 卫生记录
public class Hygienism {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
    private Integer dormNumber; //宿舍号
    private Date createDate; //创建日期
    private Date updateDate; //更新日期
    private Integer level; //卫生等级：差、一般、优秀
    private String note; //备注
}
