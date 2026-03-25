package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dao.Result;
import dao.Student;
import service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 新增学生
    @PostMapping("/create")
    public Result<String> create(@RequestBody Student student) {
        return Result.success(studentService.createStudent(student));
    }

    // 根据ID查询学生
    @GetMapping("/{id}")
    public Result<Student> getById(@PathVariable String id) {
        return Result.success(studentService.getStudentById(id));
    }
}