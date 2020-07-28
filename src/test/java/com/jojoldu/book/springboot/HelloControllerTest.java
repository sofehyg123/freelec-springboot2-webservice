package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) //Junit과 springboot 중간다리 역할을 합니다. JUnit의 내장된 실행자 대신에 spring 실행자를 선택합니다.
@WebMvcTest(controllers = HelloController.class) // 웹을 전문적으로 테스트하는 어노테이션 입니다. 각 요청을 테스트할 수 있고 스프링 MVC 테스트의 시작점 입니다.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //private을 하는 이유가 있겠지? 테스트니까 하는 경우 아니면 보안을 신경쓸려고?

    @Test
    public void helloTest() throws Exception {
        String hello = "hello";

        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void HelloDtoTest() throws Exception{
        String name = "혁기";
        int amount = 28;


        mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
                                          .param("name",name)
                                          .param("amount",String.valueOf(amount)))
                                                                         .andExpect(status().isOk())
                                                                         .andExpect(jsonPath("$.name",is(name)))
                                                                         .andExpect(jsonPath("$.amount",is(amount)));

    }
}
