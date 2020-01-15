package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

//报修记录
public class Repair {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
    private Integer dormNumber; //宿舍号
    private String phoneNumber; //报修人手机号
    private Integer goodsNumber; //物品编号
    private String cause; //报修原因
    private Date submitDate; //提交日期
    private Date doneDate; //解决日期
    private String note; //备注
}
