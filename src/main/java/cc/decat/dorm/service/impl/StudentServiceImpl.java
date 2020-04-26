package cc.decat.dorm.service.impl;

import cc.decat.dorm.mapper.StudentMapper;
import cc.decat.dorm.model.Student;
import cc.decat.dorm.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student getStudentByUserName(String username) {
        return this.getOne(new QueryWrapper<Student>().eq(username!=null, "username", username));
    }

    @Override
    public List<Student> findStudentListByDormNumber(String flatsName, String buildingNumber, Integer dormNumber) {

        return this.list(new QueryWrapper<Student>().eq("flatsName", flatsName).eq("buildingNumber", buildingNumber).eq("dormNumber", dormNumber));
    }

    @Override
    public boolean isExistByUserName(String username) {

        return this.getOne(new QueryWrapper<Student>().eq("username", username)) != null;
    }
}
