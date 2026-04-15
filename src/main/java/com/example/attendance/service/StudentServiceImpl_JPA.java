package com.example.attendance.service;

import com.example.attendance.dao.Student_JPA;
import com.example.attendance.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl_JPA implements StudentService_JPA {

    // 注入JPA Repository，替代原JDBC-template
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student_JPA saveStudent(Student_JPA student) {
        return studentRepository.save(student);
    }

    @Override
    public Student_JPA getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student_JPA> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student_JPA> getStudentsByClass(String className) {
        return studentRepository.findByClassName(className);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}