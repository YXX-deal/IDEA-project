package com.example.attendance;
import my_information.Result;
import my_information.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class StudentController {
    //接受学号，返回个人信息
    @GetMapping("/student/info/{id}")
    public Result<Student> getStudent(@PathVariable String id) {
        Student student = new Student();
        student.setId(id);
        student.setName("姚雄鑫");
        return Result.success(student);
    }
    //接受班级名称和页码
    @GetMapping("/student/list")
    public Result<String> getStudentList(
            // 接收班级名称
            @RequestParam(defaultValue = "所有班级") String className,
            // 接收页码，默认值为1
            @RequestParam(defaultValue = "1") Integer page
    ) {
        // 根据班级和页码查询列表
        String resultStr = String.format("查询到 [%s] 第 [%d] 页的学生列表", className, page);

        // 返回结果
        return Result.success(resultStr);
    }
    // 创建学生
    @PostMapping("/attendance/update")
    public Result<String> updateAttendance(@RequestBody Student student) {
        String msg = String.format("创建学生[%s]，学号为[%s]",
                student.getName(),student.getId());

        //  返回结果
        return Result.success(msg);
    }
    //接收打卡信息
    @PostMapping("/student/attendance")
    public String studentAttendance(@RequestBody Map<String, String> params){
        String studentId = params.get("studentId");
        return "学号为"+studentId+"的学生打卡成功！";
    }
    //返回课程信息
    @GetMapping("/student/course")
    public String studentCourse(){
        List<String> strlist =List.of("JAVA EE开发实践","计算机组成原理","数据库原理");
        return strlist.toString();
    }
}
