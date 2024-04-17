package dev.lsh.java8user.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@Log4j2
public class MemberController {
    @GetMapping(value = { "", "/" })
    public String home(ModelAndView mv) {
        return "index";
    }
}