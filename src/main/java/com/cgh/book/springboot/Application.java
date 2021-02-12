package com.cgh.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//Alt+Enter 로 import 할 수 있다.

@SpringBootApplication
@ComponentScan({"web"})
public class Application {      //main 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
