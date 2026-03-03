package com.demo;

import static io.u2ware.common.docs.MockMvcRestDocs.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.domain.Hello;
import com.demo.api.helloes.HelloRepository;

import io.u2ware.common.data.jpa.repository.query.JpaSpecificationBuilder;

// @SpringBootTest: main 전체 Spring 컨텍스트를 로드해서 테스트 환경 구성
// Spring 컨텍스트 : Spring이 관리하는 모든 객체(Bean)들의 집합
// @Entity, @Service, @Repository, @Controller, @Component 어노테이션이 붙은 클래스들을 자동으로 객체로 만들어서 관리하는데 이것들이 모여있는 공간을 Spring 컨텍스트(Application Context 라고 함.)

// @AutoConfigureMockMvc : MockMvc를 자동으로 설정해주는 어노테이션
// MockMvc : 실제 서버를 띄우지 않고 HTTP 요청/응답을 가짜로 테스트할 수 있게 해주는 도구
@SpringBootTest
@AutoConfigureMockMvc // 웹 테스트
class ApplicationTests {

        @Autowired
        private HelloRepository helloRepository;

        @Autowired
        private MockMvc mockMvc;

        // helloRepository 단일 테스트
        // @Test
        // void repositoryTest() throws Exception {
        // System.out.println(helloRepository);
        // }

        // Repository Test
        // @Test : 테스트 메서드 지정 (JUnit이 해당 메서드를 테스트로 인식하고 실행)
        // JUnit : Java 테스트 프레임워크 (spring-boot-start-test에 포함)
        // @Test
        // void repositoryTest() throws Exception {

        // Hello hello = new Hello();
        // hello.setName("helloUbisam");
        // hello.setEmail("ubisam");
        // hello.setEmail("ubisam@ubisam.com");

        // // Create
        // System.out.println("[[[HelloCreate]]]");
        // helloRepository.save(hello);

        // // Read
        // System.out.println("[[[HelloRead]]]");
        // List<Hello> helloList = helloRepository.findAll();
        // System.out.println(helloList);

        // // Read One
        // System.out.println("[[[HelloReadOne]]]");
        // Hello hello2 = helloRepository.findById(hello.getId()).get();
        // System.out.println(hello2);

        // // Update
        // System.out.println("[[[HelloUpdate]]]");
        // hello.setName(("helloUbisam222"));
        // hello.setEmail("ubisam222");
        // hello.setEmail("ubisam222@ubisam.com");
        // helloRepository.save(hello);
        // List<Hello> updatedList = helloRepository.findAll();
        // System.out.println(updatedList);

        // // Delete
        // System.out.println("[[[HelloDelete]]]");
        // helloRepository.delete(hello);
        // List<Hello> deletedList = helloRepository.findAll();
        // System.out.println(deletedList);
        // }

        // // 웹 요청 Test
        // @Test
        // void contextLoad2() throws Exception {
        // // perform : 요청 구간
        // // andDo : 응답 구간(결과가 나오고 나서 무언가를 하고 싶을때)
        // // andExpect : 검증 구간(결과를 기대하는 구간)

        // Hello h = new Hello();
        // h.setName("name1");
        // h.setEmail("abc@abc.com");

        // // Create
        // mockMvc.perform(post("/api/helloes").content(h)).andDo(print()).andExpect(is2xx());

        // // Read
        // mockMvc.perform(get("/api/helloes")).andDo(print()).andExpect(is2xx());
        // // mockMvc.perform(get("/api/helloes/"+
        // // h.getId())).andDo(print()).andExpect(is2xx());

        // // h.setName("name2");
        // // h.setEmail("abc1@abc1.com");

        // // Update
        // //
        // mockMvc.perform(put("/api/helloes/1").content(h)).andDo(print()).andExpect(is2xx());

        // // Delete
        // //
        // mockMvc.perform(delete("/api/helloes/1").content(h)).andDo(print()).andExpect(is2xx());

        // // Read
        // // mockMvc.perform(get("/helloes")).andDo(print()).andExpect(is2xx());
        // }

        // @Test
        // void contextLoad3() throws Exception {
        // JpaSpecificationBuilder<Hello> query = JpaSpecificationBuilder
        // .of(Hello.class);
        // query.where()
        // .and().eq("name", "홍길동")
        // .or().like("email", "abc@abc.com");
        // // select * from hello where name = '홍길동' or email like 'abc@abc.com'
        // // ==============================================
        // // select * from hello where
        // // (name = '홍길동' and email like 'abc@abc.com')
        // // or (email like 'abc2@abc.com')
        // // query.where()
        // // .andStart().and().eq("name", "홍길동")
        // // .and().like("email", "abc@abc.com").andEnd()
        // // .or().like("email", "abc2@abc.com");

        // helloRepository.findAll(query.build());

        // Hello h = new Hello();
        // h.setKeyword("g");

        // mockMvc.perform(post("/api/helloes/search")
        // .content(h))
        // .andDo(print())
        // .andExpect(is2xx());
        // }

}