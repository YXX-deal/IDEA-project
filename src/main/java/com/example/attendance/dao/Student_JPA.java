package com.example.attendance.dao;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 学生实体类，映射SQL Server数据库表
 */
@Entity  // 标记为JPA实体
@Table(name = "t_student")  // 指定表名，对应SQL Server的表
@Data  // Lombok自动生成getter/setter/toString
public class Student_JPA {

    // 主键：学生ID，SQL Server自增IDENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    // 学生姓名
    @Column(name = "student_name", length = 50, nullable = false)
    private String studentName;

    // 学号（唯一约束）
    @Column(name = "student_no", length = 20, unique = true, nullable = false)
    private String studentNo;

    // 班级（任务二：按班级查询的字段）
    @Column(name = "class_name", length = 50, nullable = false)
    private String className;

    // 手机号
    @Column(name = "phone", length = 11)
    private String phone;
}