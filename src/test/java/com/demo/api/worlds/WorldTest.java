package com.demo.api.worlds;

import static io.u2ware.common.docs.MockMvcRestDocs.delete;
import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;
import static io.u2ware.common.docs.MockMvcRestDocs.put;
import static io.u2ware.common.docs.MockMvcRestDocs.result;

import java.util.Map;

import static io.u2ware.common.docs.MockMvcRestDocs.get;
import static io.u2ware.common.docs.MockMvcRestDocs.is4xx;
import static io.u2ware.common.docs.MockMvcRestDocs.isJson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// import com.demo.domain.World;

@SpringBootTest
@AutoConfigureMockMvc
public class WorldTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private WorldDocs worldDocs;

        // Web 요청 테스트
        @Test
        void contextLoad1() throws Exception {

                // Crud -C
                mockMvc
                                .perform(post("/api/worlds")
                                                .content(worldDocs::newEnity, "월드1"))
                                .andDo(print())
                                .andExpect(is2xx())
                                .andDo(result(worldDocs::context, "entity1"));

                mockMvc
                                .perform(post("/api/worlds")
                                                .content(worldDocs::newEnity, "월드2"))
                                .andDo(print())
                                .andExpect(is2xx())
                                .andDo(result(worldDocs::context, "entity2"));

                mockMvc
                                .perform(post("/api/worlds")
                                                .content(worldDocs::newEnity, "월드3"))
                                .andDo(print())
                                .andExpect(is2xx())
                                .andDo(result(worldDocs::context, "entity3"));

                mockMvc
                                .perform(post("/api/worlds")
                                                .content(worldDocs::newEnity, "월드4"))
                                .andDo(print())
                                .andExpect(is2xx())
                                .andDo(result(worldDocs::context, "entity4"));

                // Read

                String url = worldDocs.context("entity1", "$._links.self.href");
                System.out.println("url :" + url);

                mockMvc
                                .perform(post(url))
                                .andExpect(is2xx())
                                .andDo(print());
                mockMvc
                                .perform(get(url))
                                .andExpect(is4xx())
                                .andDo(print());

                // Update
                Map<String, Object> entity = worldDocs.context("entity2", "$");
                mockMvc.perform(put(url).content(worldDocs::updateEntityName, entity, "월드1234"))
                                .andDo(print())
                                .andExpect(is2xx())
                                .andDo(print())
                                .andExpect(isJson("$.name", "월드1234"));

                // Read - 수정 후 단건 체크
                mockMvc.perform(post(url))
                                .andDo(print())
                                .andExpect(is2xx())
                                .andExpect(isJson("$.name", "월드1234"));

                // Delete
                mockMvc.perform(delete(url))
                                .andExpect(is2xx())
                                .andDo(print());

                // Read - 삭제 후 단건 조회(삭제했으니 4xx 기대)
                mockMvc.perform(post(url))
                                .andDo(print())
                                .andExpect(is4xx())
                                .andDo(print());

                // 10개

                mockMvc.perform(post("/api/worlds/search")
                                .content(worldDocs::setKeyword, ""))
                                .andDo(print())
                                .andExpect(is2xx());

                mockMvc.perform(post("/api/worlds/search").content(worldDocs::setKeyword, "월드1234"))
                                .andDo(print())
                                .andExpect(is2xx());
        }
}
