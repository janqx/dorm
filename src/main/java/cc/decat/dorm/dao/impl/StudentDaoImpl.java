package cc.decat.dorm.dao.impl;

import cc.decat.dorm.dao.StudentDao;
import cc.decat.dorm.model.Student;
import cc.decat.dorm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {

    private static Connection conn = DBUtil.getConn();

    @Override
    public List<Student> getAllStudent() {

        String sql = "SELECT * FROM student";
        List<Student> studentList = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Student student = null;

//                Student student = new Student(
//                        resultSet.getInt(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getInt(4),
//                        resultSet.getInt(5),
//                        resultSet.getString(6),
//                        resultSet.getString(7),
//                        resultSet.getString(8),
//                        resultSet.getString(9),
//                        resultSet.getString(10),
//                        resultSet.getString(11),
//                        resultSet.getString(12),
//                        resultSet.getInt(13),
//                        resultSet.getInt(14),
//                        resultSet.getDate(15)
//                );
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    @Override
    public Student findStudentByUserName(String username) {

        String sql = "SELECT * FROM student WHERE username=?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
//                student = new Student(
//                        resultSet.getInt(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getInt(4),
//                        resultSet.getInt(5),
//                        resultSet.getString(6),
//                        resultSet.getString(7),
//                        resultSet.getString(8),
//                        resultSet.getString(9),
//                        resultSet.getString(10),
//                        resultSet.getString(11),
//                        resultSet.getString(12),
//                        resultSet.getInt(13),
//                        resultSet.getInt(14),
//                        resultSet.getDate(15)
//                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
