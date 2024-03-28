package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("date2",  "hello!!");
        return "hello";
    }
}
