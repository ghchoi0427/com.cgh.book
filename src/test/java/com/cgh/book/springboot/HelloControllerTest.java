package com.cgh.book.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import web.HelloController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)    //테스트가 진행될 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행.
@WebMvcTest(controllers = HelloController.class)//Controller,ControllerAdvice등 사용가능
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 bean을 주입받는다.
    private MockMvc mvc;//웹 API를 테스트할때 씀. 스프링MVC테스트의 시작점. 이 클래스를 통해 요청에 대한 API테스트 진행

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  //GET요청. 체이닝을 통해 여러 검증기능을 이어서 선언 가능
                .andExpect((status().isOk()))   //Http status 검증
                .andExpect(content().string(hello));    //반환값이 "hello"가 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)    //API테스트시 사용될 요청 파라미터 설정(String만 허용)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    //JSON응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
