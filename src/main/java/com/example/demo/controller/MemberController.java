package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 회원가입
// 회원목록
// 회원 상세보기
@Controller
public class MemberController {
    private final MemberService memberService;
    // 생성자 주입 : Autowired 어노테이션을 사용하여 MemberService를 주입받는다.
    @Autowired  // Autowired는 생략 가능
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String returnFormHtml(){
        return "members/createMemberForm";
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/members/new")
    public String createData(@RequestParam(value="myName")String name){
        Member member = new Member();
        member.setName(name);

        memberService.create(member);

        return "redirect:/";
    }





}
