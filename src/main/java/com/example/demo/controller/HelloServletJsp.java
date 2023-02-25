package com.example.demo.controller;

import com.example.demo.domain.Hello;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServletJsp", urlPatterns = "/hello-servlet-jsp")
public class HelloServletJsp extends HttpServlet {

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // html_name 단일 변수가 아닌, Hello 객체 age, name을 담아서
//        // 화면에도 name, age를 뿌려주도록 return
//
//        req.setAttribute("html_name", "LimSungHyuk");
//        String path = "WEB-INF/hello.jsp";
//        RequestDispatcher rd = req.getRequestDispatcher(path);
//        rd.forward(req, resp);
//    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        Hello hello = new Hello();
        hello.setAge(29);
        hello.setName("Lim");
        req.setAttribute("Hello", hello);
        String path = "WEB-INF/hello.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);

    }
}