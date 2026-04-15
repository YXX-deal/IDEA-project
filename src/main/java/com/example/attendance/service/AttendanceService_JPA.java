package com.example.attendance.service;

import com.example.attendance.dao.Attendance_JPA;
import java.util.List;

public interface AttendanceService_JPA {
    Attendance_JPA saveAttendance(Attendance_JPA attendance);
    Attendance_JPA getAttendanceById(Long id);
    List<Attendance_JPA> getAllAttendances();
    List<Attendance_JPA> getAttendancesByStudentId(Long studentId);
    void deleteAttendance(Long id);
}