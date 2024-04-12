package com.k22.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public String home(){
        return "home";
    }
    @GetMapping("/create")
    public String create(){
        return "create";
    }
    @GetMapping("/profile")
    public String detail(){
        return "detail";
    }
    @GetMapping("/confirm")
    public String confirm(){
        return "cf/confirm";
    }
    @PostMapping("/save")
    public String save(@RequestParam String name, @RequestParam int age){
        System.out.println(name+age);
        return "redirect:/student/confirm";
    }
}
