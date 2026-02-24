package com.demo;

import static io.u2ware.common.docs.MockMvcRestDocs.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// 실제 코드보다 테스트 코드를 더 중점적으로 
// Test Driven Design
import com.demo.helloes.Hello;
import com.demo.helloes.HelloRepository;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private HelloRepository helloRepository;

	@Autowired
	private MockMvc mockMvc;

	// Repository Test
	@Test
	void contextLoads1() throws Exception {

		Hello hello = new Hello();
		hello.setMessage("유비샘");
		hello.setEmail("ubisam@ubisam.com");

		helloRepository.save(hello);
	}

	// 웹 요청 Test
	// 숙제 : CRUD 테스트
	@Test
	void contextLoads2() throws Exception {

		// save
		Hello hello = new Hello();
		hello.setMessage("유비샘12341234");
		hello.setEmail("ubisam1234@ubisam.com");

		// Request Body Post
		mockMvc.perform(post("/helloes").content(hello)).andDo(print()).andExpect(is2xx());

		// perform() : 요청 구간
		// andDo() : 결과가 나오고 나서 뭔가를 하고 싶을 때
		// andDo(print()) : 결과 출력
		// andExpect() : 결과를 기대
		// andExpect(is2xx()) : 2xx대면 성공함
		mockMvc.perform(get("/helloes")).andDo(print()).andExpect(is2xx());

	}

}
