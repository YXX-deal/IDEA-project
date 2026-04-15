package com.example.attendance.service;

import com.example.attendance.dao.Attendance_JPA;
import com.example.attendance.dao.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceServiceImpl_JPA implements AttendanceService_JPA {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance_JPA saveAttendance(Attendance_JPA attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance_JPA getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attendance_JPA> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public List<Attendance_JPA> getAttendancesByStudentId(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}