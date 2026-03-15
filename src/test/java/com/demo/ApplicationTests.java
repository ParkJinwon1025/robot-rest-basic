package com.demo;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest: main 전체 Spring 컨텍스트를 로드해서 테스트 환경 구성
// Spring 컨텍스트 : Spring이 관리하는 모든 객체(Bean)들의 집합
// @Entity, @Service, @Repository, @Controller, @Component 어노테이션이 붙은 클래스들을 자동으로 객체로 만들어서 관리하는데 이것들이 모여있는 공간을 Spring 컨텍스트(Application Context 라고 함.)

// @AutoConfigureMockMvc : MockMvc를 자동으로 설정해주는 어노테이션
// MockMvc : 실제 서버를 띄우지 않고 HTTP 요청/응답을 가짜로 테스트할 수 있게 해주는 도구
@SpringBootTest
@AutoConfigureMockMvc // 웹 테스트
class ApplicationTests {

}