package dev.lsh.java8user.member.controller;

import dev.lsh.java8user.member.dto.MemberCreateDTO;
import dev.lsh.java8user.member.dto.MemberCreateResponseDTO;
import dev.lsh.java8user.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping(value = { "", "/" })
    public String home(ModelAndView mv) {
        return "index";
    }

    @PostMapping("/api/user/join")
    public ResponseEntity<MemberCreateResponseDTO> insert(@RequestBody MemberCreateDTO memberCreateDTO) {
        MemberCreateResponseDTO memberCreateResponseDTO = this.memberService.insert(memberCreateDTO);
        return ResponseEntity.ok(memberCreateResponseDTO);
    }
}