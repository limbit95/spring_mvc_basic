package com.example.demo.controller;

import com.example.demo.domain.Hello;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "helloServletJson", urlPatterns = "/hello-servlet-json")
public class HelloServletJson extends HttpServlet {
    // Servlet에서 json 형태를 만들어주려면 objectMapper 라는 클래스를 import 해야 함
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hello hello = new Hello();
        hello.setAge(29);
        hello.setName("Lim");
        String result = objectMapper.writeValueAsString(hello);
        resp.getWriter().write(result);

    }
}
