package cc.decat.dorm.dao;

import cc.decat.dorm.model.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudent(); //获取全部学生
    public Student findStudentByUserName(String username); //根据用户名获取学生
}
