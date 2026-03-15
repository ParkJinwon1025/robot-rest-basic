package com.demo.api.helloes;

import static io.u2ware.common.docs.MockMvcRestDocs.delete;
import static io.u2ware.common.docs.MockMvcRestDocs.get;
import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.is4xx;
import static io.u2ware.common.docs.MockMvcRestDocs.isJson;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;
import static io.u2ware.common.docs.MockMvcRestDocs.put;
import static io.u2ware.common.docs.MockMvcRestDocs.result;
// import static io.u2ware.common.docs.MockMvcRestDocs.put;

import java.util.Map;
// import java.util.function.BiConsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloDocs helloDocs;

    // 웹 요청 Test
    @Test
    void contextLoad1() throws Exception {
        // perform : 요청 구간
        // andDo : 응답 구간(결과가 나오고 나서 무언가를 하고 싶을때)
        // andExpect : 검증 구간(결과를 기대하는 구간)

        // BiConsumer<String, String> key = (k, v) -> {
        // System.out.println(k + ":" + v);
        // };

        // BiConsumer로 아이디가 뭐로 들어오든 id를 캐치할 수 있음.(다음 단계로 진행 가능)
        // Create
        // mockMvc.perform(post("/api/helloes").content(h)).andDo(print()).andExpect(is2xx())
        // .andExpect(isJson("$.name", "test1"))
        // .andDo(result(docs::context, "a")); // a: log로 나오는 이름

        // mockMvc.perform(get("/api/helloes")).andExpect(is4xx()).andDo(print()); //
        // error
        // mockMvc
        // .perform(get("/api/helloes"))
        // .andExpect(is2xx())
        // .andDo(print());

        // mockMvc
        // .perform(get("/api/helloes/search"))
        // .andExpect(is4xx())
        // .andDo(print());
        // mockMvc
        // .perform(post("/api/helloes/search"))
        // .andExpect(is4xx())
        // .andDo(print());

        // Create
        mockMvc
                .perform(post("/api/helloes")
                        .content(helloDocs::newEnity, "김길동"))
                .andDo(print())
                .andExpect(is2xx())
                .andDo(result(helloDocs::context, "entity1"));

        mockMvc
                .perform(post("/api/helloes")
                        .content(helloDocs::newEnity, "박길동"))
                .andDo(print())
                .andExpect(is2xx())
                .andDo(result(helloDocs::context, "entity1"));

        mockMvc
                .perform(post("/api/helloes")
                        .content(helloDocs::newEnity, "홍길동"))
                .andDo(print())
                .andExpect(is2xx())
                .andDo(result(helloDocs::context, "entity1"));

        mockMvc
                .perform(post("/api/helloes")
                        .content(helloDocs::newEnity, "오길동"))
                .andDo(print())
                .andExpect(is2xx())
                .andDo(result(helloDocs::context, "entity1"));

        // Read
        String url = helloDocs.context("entity1", "$._links.self.href");
        System.out.println("url : " + url);

        mockMvc
                .perform(get(url))
                .andExpect(is2xx())
                .andDo(print());
        mockMvc
                .perform(post(url))
                .andExpect(is4xx())
                .andDo(print());

        // Update
        Map<String, Object> entity = helloDocs.context("entity1", "$");
        mockMvc
                .perform(put(url)
                        .content(helloDocs::updateEntity, entity, "홍길동1234"))
                .andExpect(is2xx())
                .andDo(print())
                .andExpect(isJson("$.name", "홍길동1234"));

        // Read - 수정 후 단건 체크
        mockMvc.perform(get(url))
                .andExpect(is2xx())
                .andDo(print());

        // Delete
        mockMvc
                .perform(delete(url))
                .andExpect(is2xx())
                .andDo(print());

        // Read - 데이터가 없으므로 is4xx() 기대
        mockMvc
                .perform(get(url))
                .andExpect(is4xx())
                .andDo(print());

        // 10개
    }

}
