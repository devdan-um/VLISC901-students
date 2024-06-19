package com.univer.students.controller;

import com.univer.students.model.entity.StudentsEntity;
import com.univer.students.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class formController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name,
                             @RequestParam String tel,
                             @RequestParam String email,
                             @RequestParam String mat,
                             Model model) {
        StudentsEntity student = new StudentsEntity();
        student.setName(name);
        student.setTel(tel);
        student.setEmail(email);
        student.setMat(mat);
        studentsRepository.save(student);

        model.addAttribute("message", "Student saved successfully!");
        return "result";
    }
}
