package com.dell.projectOne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerOne {
    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }
}
