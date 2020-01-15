package cc.decat.dorm.service;

import cc.decat.dorm.model.Dorm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DormService extends IService<Dorm> {

    // 通过公寓名->栋号->寝室号获取寝室
    public Dorm findDormByDormNumber(String flatsName, Integer buildingNumber, Integer dormNumber);

    // 通过公寓名->栋号获取寝室
    public List<Dorm> findDormByBuildingNumber(String flatsName, Integer buildingNumber);

    // 通过公寓名获取寝室
    public List<Dorm> findDormByFlats(String flatsName);

//    // 通过学号或者用户名或者手机号获取寝室
//    public Dorm findDormByStudentInfo(String studentNumber, String username, String phoneNumber);


}
