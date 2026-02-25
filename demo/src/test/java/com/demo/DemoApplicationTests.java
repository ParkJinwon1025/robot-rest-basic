package com.demo;

import static io.u2ware.common.docs.MockMvcRestDocs.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// 실제 코드보다 테스트 코드를 더 중점적으로 
// Test Driven Design
import com.demo.helloes.Hello;
import com.demo.helloes.HelloRepository;

// @SpringBootTest: main 전체 Spring 컨텍스트를 로드해서 테스트 환경 구성
// Spring 컨텍스트 : Spring이 관리하는 모든 객체(Bean)들의 집합
// @Entity, @Service, @Repository, @Controller, @Component 어노테이션이 붙은 클래스들을 자동으로 객체로 만들어서 관리하는데 이것들이 모여있는 공간을 Spring 컨텍스트(Application Context 라고 함.)
@SpringBootTest

// @AutoConfigureMockMvc : MockMvc를 자동으로 설정해주는 어노테이션
// MockMvc : 실제 서버를 띄우지 않고 HTTP 요청/응답을 가짜로 테스트할 수 있게 해주는 도구

@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private HelloRepository helloRepository;

	@Autowired
	private MockMvc mockMvc;

	// Repository Test
	// @Test : 테스트 메서드 지정 (JUnit이 해당 메서드를 테스트로 인식하고 실행)
	// JUnit : Java 테스트 프레임워크 (spring-boot-start-test에 포함)
	@Test
	void repositoryTest() throws Exception {

		Hello hello = new Hello();
		hello.setName("helloUbisam");
		hello.setMessage("ubisam");
		hello.setEmail("ubisam@ubisam.com");

		// Create
		System.out.println("[[[HelloCreate]]]");
		helloRepository.save(hello);

		// Read
		System.out.println("[[[HelloRead]]]");
		List<Hello> helloList = helloRepository.findAll();
		System.out.println(helloList);

		// Read One
		System.out.println("[[[HelloReadOne]]]");
		Hello hello2 = helloRepository.findById(hello.getId()).get();
		System.out.println(hello2);

		// Update
		System.out.println("[[[HelloUpdate]]]");
		hello.setName(("helloUbisam222"));
		hello.setMessage("ubisam222");
		hello.setEmail("ubisam222@ubisam.com");
		helloRepository.save(hello);
		List<Hello> updatedList = helloRepository.findAll();
		System.out.println(updatedList);

		// Delete
		System.out.println("[[[HelloDelete]]]");
		helloRepository.delete(hello);
		List<Hello> deletedList = helloRepository.findAll();
		System.out.println(deletedList);
	}

	// 웹 요청 Test
	// 숙제 : CRUD 테스트
	@Test
	void webTest() throws Exception {

		// save
		Hello hello = new Hello();
		hello.setName("helloUbisam");
		hello.setMessage("ubisam");
		hello.setEmail("ubisam@ubisam.com");

		Hello hello2 = new Hello();
		hello2.setName("helloUbisam2");
		hello2.setMessage("ubisam2");
		hello2.setEmail("ubisam2@ubisam.com");

		// Create
		// Request Body Post

		try {
			mockMvc.perform(post("/helloes").content(hello)).andDo(print()).andExpect(is2xx());
			mockMvc.perform(post("/helloes").content(hello2)).andDo(print()).andExpect(is2xx());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Read
		// perform() : 요청 구간
		// andDo() : 결과가 나오고 나서 뭔가를 하고 싶을 때
		// andDo(print()) : 결과 출력
		// andExpect() : 결과를 기대
		// andExpect(is2xx()) : 2xx대면 성공함
		mockMvc.perform(get("/helloes")).andDo(print()).andExpect(is2xx());

		// Read One
		// hello의 id를 가져올 방법을 몰라서 일단 하드코딩
		mockMvc.perform(get("/helloes/" +
				1)).andDo(print()).andExpect(is2xx());

		// Update
		hello.setMessage("ubisam2");
		hello.setEmail("ubisam2@ubisam.com");
		mockMvc.perform(put("/helloes/" +
				1).content(hello)).andDo(print()).andExpect(is2xx());
		mockMvc.perform(get("/helloes")).andDo(print()).andExpect(is2xx());

		// Delete
		mockMvc.perform(delete("/helloes/" +
				1)).andDo(print()).andExpect(is2xx());
		mockMvc.perform(get("/helloes")).andDo(print()).andExpect(is2xx());
	}

}
