package com.example.attendance.service;

import com.example.attendance.dao.Student_JPA;
import java.util.List;

public interface StudentService_JPA {
    // 新增/更新学生
    Student_JPA saveStudent(Student_JPA student);
    // 根据ID查询学生
    Student_JPA getStudentById(Long id);
    // 查询所有学生
    List<Student_JPA> getAllStudents();
    // 根据班级查询学生（任务二要求）
    List<Student_JPA> getStudentsByClass(String className);
    // 删除学生
    void deleteStudent(Long id);
}