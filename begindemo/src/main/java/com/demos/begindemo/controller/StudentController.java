package com.demos.begindemo.controller;

import com.demos.begindemo.pojo.bo.StudentBO;
import com.demos.begindemo.service.StudentService;
import com.demos.begindemo.util.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/page")
    public ResponseData selectForPage(StudentBO studentBO) {
        return studentService.selectForPage(studentBO);
    }
}