package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 회원가입
// 회원목록
// 회원 상세보기
// 스프링빈에 등록 -> 스프링빈이란? 스프링프레임워크가 미리 객체를 만들어 놓는 것
@Controller
// @Bean, @Component 어노테이션을 통해 선언되어 있는 것들은 Bean으로 등록
//
public class MemberController {
    private final MemberService memberService;
    // 생성자 주입 : Autowired 어노테이션을 사용하여 MemberService를 주입받는다.
    @Autowired  // Autowired는 생략 가능(하나의 생성자만 주입할 때만, 두 개 이상부터는 필요)
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
    public String createData(@RequestParam(value="myName")String name) throws SQLException {
        Member member = new Member();
        member.setName(name);

        memberService.create(member);

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String membersList(Model model) throws SQLException {
        model.addAttribute("members", this.memberService.findAll());

        return "members/memberList";
    }

    @GetMapping("/members/detail")
    public String membersDetail(@RequestParam(value="id")Long id, Model model) throws SQLException {
        model.addAttribute("member", this.memberService.findById(id));

        return "members/memberDetail";
    }

    @GetMapping("/members/findbyname")
    @ResponseBody
    public List<Member> memberFindByName(@RequestParam(value="name")String name){

        return memberService.findByName(name);
    }

//    @GetMapping("/members/findbyidandname")
//    @ResponseBody
//    public List<Member> memberFindByIdAndName(@RequestParam(value="id")Long id, @RequestParam(value="name")String name){
//
//        return memberService.findByIdAndName(id, name);
//    }

//    @GetMapping("/members/search")
//    public String membersSearch(){
//
//
//        return "members/membersearch";
//    }



}