package com.example.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 学生数据访问接口，继承JpaRepository获得基础CRUD
 */
@Repository
public interface StudentRepository extends JpaRepository<Student_JPA, Long> {

    /**
     * 任务要求：自定义查询方法（根据班级查询）
     * Spring Data JPA自动生成SQL，无需手写
     * 对应SQL Server SQL: SELECT * FROM t_student WHERE class_name = ?
     */
    List<Student_JPA> findByClassName(String className);

    /**
     * 额外自定义方法：根据学号查询学生
     */
    Student_JPA findByStudentNo(String studentNo);
}