package com.jpa.bbs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    @RequestMapping("/")
    public String test(Model model){
        model.addAttribute("name", "test");
        return "main";
    }
}
