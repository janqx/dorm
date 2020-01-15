package cc.decat.dorm.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

// 宿舍
public class Dorm {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
    private Integer dormNumber; //宿舍号
    private Integer maxNumber; //可住人数
    private Integer currentNumber; //已住人数

    public Dorm(Integer id, String flatsName, String buildingNumber, Integer dormNumber, Integer maxNumber, Integer currentNumber) {
        this.id = id;
        this.flatsName = flatsName;
        this.buildingNumber = buildingNumber;
        this.dormNumber = dormNumber;
        this.maxNumber = maxNumber;
        this.currentNumber = currentNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlatsName() {
        return flatsName;
    }

    public void setFlatsName(String flatsName) {
        this.flatsName = flatsName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(Integer dormNumber) {
        this.dormNumber = dormNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }
}
