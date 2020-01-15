package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//公寓
public class Flats {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name; //公寓名
}
