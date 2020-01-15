package cc.decat.dorm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Student {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id; //id
    private String username; //用户名
    private String name; //姓名
    private Integer sex; //性别，1：男、0：女
    private Integer age; //年龄
    private String studentNumber; //学号
    private String phoneNumber; //手机号
    private String college; //学院
    private String specialty; //专业
    private String grade; //年级
    private String classes; //班级
    private String flatsName; //公寓名
    private String buildingNumber; //栋号
    private Integer dormNumber; //宿舍号
    private Date InDate; //入住时间

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", studentNumber='" + studentNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", college='" + college + '\'' +
                ", specialty='" + specialty + '\'' +
                ", grade='" + grade + '\'' +
                ", classes='" + classes + '\'' +
                ", flatsName='" + flatsName + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", dormNumber=" + dormNumber +
                ", InDate=" + InDate +
                '}';
    }

    public Student(Integer id, String username, String name, Integer sex, Integer age, String studentNumber, String phoneNumber, String college, String specialty, String grade, String classes, String flatsName, String buildingNumber, Integer dormNumber, Date inDate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
        this.college = college;
        this.specialty = specialty;
        this.grade = grade;
        this.classes = classes;
        this.flatsName = flatsName;
        this.buildingNumber = buildingNumber;
        this.dormNumber = dormNumber;
        InDate = inDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
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

    public Date getInDate() {
        return InDate;
    }

    public void setInDate(Date inDate) {
        InDate = inDate;
    }
}
