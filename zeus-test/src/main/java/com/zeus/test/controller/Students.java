package com.zeus.test.controller;

import com.zeus.test.annotion.TimeMonitor;
import com.zeus.test.domain.Student;
import com.zeus.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author keven
 * @date 2018-01-17 上午11:36
 * @Description
 */
@RestController
public class Students {

    private final StudentService studentService;

    @Autowired
    public Students(StudentService studentService) {
        this.studentService = studentService;
    }

    @TimeMonitor
    @GetMapping("api/student/find-by-id")
    public Student findById(@RequestParam Long id) {
        return studentService.findById(id);
    }

}
