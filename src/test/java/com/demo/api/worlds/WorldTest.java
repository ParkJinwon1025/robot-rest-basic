package com.demo.api.worlds;

import static io.u2ware.common.docs.MockMvcRestDocs.delete;
import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;
import static io.u2ware.common.docs.MockMvcRestDocs.put;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.domain.World;

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

                // mockMvc.perform(get("/api/worlds"))

                // mockMvc.perform(post("/api/worlds")
                // .content(w))
                // .andDo(print())
                // .andExpect(is2xx());

                // Get
                System.out.println("GetGetGetGet");
                // mockMvc.perform(post("/api/worlds"))
                // .andDo(print())
                // .andExpect(is2xx());

                World nw = new World();
                nw.setKeyword("company");
                mockMvc.perform(post("/api/worlds/search"))
                                .andDo(print())
                                .andExpect(is2xx());

                // 단일 Get
                System.out.println("GetOneGetOneGetOne");
                mockMvc.perform(post("/api/worlds/1")).andDo(print()).andExpect(is2xx());

                // 단일 Put
                // System.out.println("PutPutPutPutPut");
                // w.setName("ubisam2");
                // w.setPhoneNumber("5678");
                // mockMvc.perform(put("/api/worlds/1").content(w)).andDo(print()).andExpect(is2xx());

                // // Delete
                mockMvc.perform(delete("/api/worlds/1")).andDo(print()).andExpect(is2xx());

        }
}
