package com.example.attendance.controller;

import com.example.attendance.dao.AttendanceRepository;
import com.example.attendance.dao.Attendance_JPA;
import com.example.attendance.dao.StudentRepository;
import com.example.attendance.dao.Student_JPA;
import com.example.attendance.service.AttendanceService_JPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController_JPA {

    // 1. 注入 Service 接口（Spring 会自动找到实现类）
    @Autowired
    private AttendanceService_JPA attendanceService;
    // 👇 新增：注入 Repository 实例
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Attendance_JPA addAttendance(@RequestBody Attendance_JPA attendance) {
        // 2. 调用对象的非静态方法（正确）
        attendanceService.saveAttendance(attendance);
        // 2. 从数据库查询完整考勤（先拿到 studentId）
        Attendance_JPA savedAttendance = attendanceRepository.findById(attendance.getAttendanceId()).orElseThrow();

        // 🔴 3. 【关键兜底】手动根据 studentId 查询学生，直接 set 进去！
        Student_JPA student = studentRepository.findById(savedAttendance.getStudentId()).orElseThrow();
        savedAttendance.setStudent(student);
        // 4. 返回带完整学生信息的考勤数据
        return savedAttendance;
    }
}