package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 어노테이션 : 스프링에서 지원하는 다양한 어노테이션 중에 하나
// springboot를 통해 앱을 실행하려면 springbootapplication 어노테이션이 있어야 한다

// Servlet을 사용하려면 Servlet 어노테이션을 Application 클래스 위에 선언해줘야 함
@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
