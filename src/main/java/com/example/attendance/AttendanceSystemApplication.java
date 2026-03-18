package com.example.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class AttendanceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceSystemApplication.class, args);
    }

    @GetMapping("hello")
    public String hello() {
        return "欢迎来到班级考勤管理系统";
    }
    @RestController
    public static class MyInformationController {
        @GetMapping("/about")
        public String about() {
            // 3. 返回你自己的信息
            return "姓名：姚雄鑫<br>年龄：20<br>专业：网络空间安全<br>爱好：看小说";
        }
    }

}
