package com.k22.student.controller;
import com.k22.student.model.Student;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public String home(Model model){
        String msg = "Xin chao";
        model.addAttribute("message",msg);
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create";
    }
    @GetMapping("/profile/{id}/{name}")
    public String detail(@PathVariable int id, @PathVariable String name, Model model){
        System.out.println(name);
        model.addAttribute("name", name);
        return "detail";
    }
    @GetMapping("/confirm")
    public String confirm(){
        return "cf/confirm";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
        System.out.println(student);
        return "redirect:/student/confirm";
    }
}