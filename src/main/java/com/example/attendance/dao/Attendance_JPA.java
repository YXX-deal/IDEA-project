package com.example.attendance.dao;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 考勤实体类，关联学生表
 */
@Entity
@Table(name = "t_attendance")
@Data
public class Attendance_JPA {

    // 主键：考勤ID，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id", nullable = false)
    private Long attendanceId;

    // 关联学生ID（外键，关联t_student.student_id）
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    // 考勤时间
    @Column(name = "attendance_time", nullable = false)
    private LocalDateTime attendanceTime;

    // 考勤状态：0-缺勤，1-出勤，2-迟到
    @Column(name = "status", nullable = false)
    private Integer status;

    // 备注
    @Column(name = "remark", length = 200)
    private String remark;

    // 关联学生实体（懒加载，提升性能）
    @ManyToOne(fetch = FetchType.EAGER) // 用 EAGER 立即加载，解决 null 问题
// 2. 只维护关联关系，不重复写入外键（studentId 字段负责写入）
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student_JPA student;
}