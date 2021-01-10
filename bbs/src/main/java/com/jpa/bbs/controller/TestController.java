package com.jpa.bbs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class TestController {

    @RequestMapping("/")
    public String main(Model model){
        return "redirect:/main";
    }

    @RequestMapping("/main")
    public String test(Model model){
        model.addAttribute("name", "test");
        return "board/main";
    }

    @RequestMapping("/board")
    public String test2(Model model){
        model.addAttribute("name", "test");
        return "board/board_detail";
    }

    @RequestMapping("/board_write")
    public String test3(){
        return "board/board_write";
    }

    @RequestMapping("/board_modify")
    public String test4(){
        return "board/board_modify";
    }

    @RequestMapping("/member/logout")
    public String logout(SessionStatus sessionStatus, HttpSession session) {

        if(session != null) {
            session.invalidate();
        }

        return "redirect:/main"; // /spring 으로 리다이렉트
    }
}
