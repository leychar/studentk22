package com.k22.student.controller;

import com.k22.student.model.Subject;
import com.k22.student.service.SubjService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RequestMapping("/subj")
@Controller
public class SubjectController {
    @GetMapping
    public String getList(Model model){
        ArrayList<Subject> list = SubjService.getList();
        model.addAttribute("list", list);
        return "subject/getList";
    }
    @GetMapping("/create")
    public String taoMoi(Model model){
        Subject subject = new Subject();
        model.addAttribute("sj", subject);
        return "subject/create";
    }
    @GetMapping("/confirm")
    public String confirm(){
        return "cf/confirm";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Subject subject){
        SubjService.create(subject);
        return "redirect:/subj/confirm";
    }
}
