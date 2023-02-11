package com.example.demo.controller;

import com.example.demo.domain.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 컨트롤러 어노테이션을 통해 클라이언트(사용자)의 요청을 받아주는 역할
@Controller
public class HelloController {

    // GetMapping은 사용자가 get 요청을 했을 경우 받아주는 역할
    // Post 요청 경우에는 PostMapping을 사용
    // GetMapping, PostMapping 뒤에 받아주는 url을 넣어 경로를 잡아줌
    @GetMapping("/hello-spring")
    
    // ResponseBody가 있으면 사용자에게 data를 내려주고,
    // ResponseBody가 없으면 사용자에게 화면을 내려준다는 뜻
    @ResponseBody
    public String helloSpring(){
        return "hello-world-spring";
    }

    // responseBody 어노테이션이 없고, return 타입이 String 이면, templates/해당주소.html 을 찾으러 감
    // 밑의 같은 경우는 return에 걸려있는 hello.html 파일을 찾아 retunr 해준다
    // Model 객체를 주입하지 않고, html만 리턴했을 때 정적인 html을 return 함
    // @RequestParam가 입력 값을 받고, 받은 입력 값을 출력해주는 역할
    // ReauestParam이란 url의 ?을 통해 데이터를 서버로 넘어온 데이터를 꺼내는 것
    @GetMapping("/hello-spring-html")
    public String helloSpringHtmlData(@RequestParam(value="input_name", required = false)String name, Model model){
        model.addAttribute("html_name", name); //
        return "hello";
    }

    @GetMapping("/lim-html")
    public String limHtml(){
        return "lim";
    }

    //frontend / backend 구분 controller
    @GetMapping("/hello-spring-frontend")
    public String helloSpringFrontend(){
        return "hello_frontend";
    }
    // 이름(data)만을 return 해주는 API
    @GetMapping("/hello-string")
    @ResponseBody
    // text 타입
    public String helloString(){
        return "LimSungHyuk";
    }
    
    // return하는 데이터 타입은 현재 JSON이 웹서버에서 표준이 되어가고 있음
    // json은 key:value로 이루어진 데이터 타입으로서, 자바의 객체와 유사함
    // 객체를 만들어서 객체를 return하면 json타입으로 자동 return 됨
    @GetMapping("/hello-json")
    @ResponseBody
    // json타입
    public Hello helloJson(){
        Hello h1 = new Hello();
        h1.setName("Lim Sung Hyuk");
        h1.setAge(29);
        return h1;
    }

    @PostMapping("hello-post")
    @ResponseBody
    public String helloPost(@RequestBody Hello hello){
        System.out.println(hello.getName());
        System.out.println(hello.getAge());
        return "ok";
    }
    // 요청방식에는 크게 2가지
    // 1. get 요청
    //    1) url을 통해 요청하는 것
    //    2) url에 필요한 데이터도 넣어서 요청하는 것
    // 2. post 요청
    //    1) form-data에 넣어서 요청하는 방식
    //      가) @RequestParam (전형적인 회원가입 형식) ex) ?name=lim&email=test@naver.com
    //    2) body에 넣어서 보내는 방식(raw-json)
    //      나) @RequestBody


}
