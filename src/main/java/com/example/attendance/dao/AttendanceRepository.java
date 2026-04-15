package com.example.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 考勤数据访问接口
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance_JPA, Long> {

    /**
     * 任务要求：关联查询方法（根据学生ID查询该学生的所有考勤）
     */
    List<Attendance_JPA> findByStudentId(Long studentId);

    /**
     * 额外方法：根据学生ID+状态查询考勤（统计出勤次数）
     */
    long countByStudentIdAndStatus(Long studentId, Integer status);
}