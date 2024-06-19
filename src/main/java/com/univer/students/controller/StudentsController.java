package com.univer.students.controller;

import com.univer.students.StudentService;
import com.univer.students.model.entity.StudentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/Student")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentsEntity createStudent(@RequestBody StudentsEntity studentsEntity){
        return studentService.createStudent(studentsEntity);
    }

    @GetMapping
    public List<StudentsEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentsEntity searchStudentById(@PathVariable("id") Integer id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
    }
}
