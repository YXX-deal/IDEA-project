package com.example.attendance.controller;

import com.example.attendance.dao.Student_JPA;
import com.example.attendance.service.StudentService_JPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController_JPA {

    @Autowired
    private StudentService_JPA studentService;

    // 新增学生（POST）
    @PostMapping
    public Student_JPA addStudent(@RequestBody Student_JPA student) {
        return studentService.saveStudent(student);
    }

    // 根据ID查询学生（GET）
    @GetMapping("/{id}")
    public Student_JPA getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // 查询所有学生（GET）
    @GetMapping
    public List<Student_JPA> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 根据班级查询学生（任务二要求，GET）
    @GetMapping("/class/{className}")
    public List<Student_JPA> getStudentsByClass(@PathVariable String className) {
        return studentService.getStudentsByClass(className);
    }

    // 更新学生（PUT）
    @PutMapping
    public Student_JPA updateStudent(@RequestBody Student_JPA student) {
        return studentService.saveStudent(student);
    }

    // 删除学生（DELETE）
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}