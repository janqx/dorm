package cc.decat.dorm.service;

import cc.decat.dorm.model.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StudentService extends IService<Student> {

    public Student getStudentByUserName(String username);
    public List<Student> findStudentListByDormNumber(String flatsName, String buildingNumber, Integer dormNumber);
}
