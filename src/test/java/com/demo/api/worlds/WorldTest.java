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

import io.u2ware.common.data.jpa.repository.query.JpaSpecificationBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class WorldTest {

        @Autowired
        private WorldRepository worldRepository;

        @Autowired
        private MockMvc mockMvc;

        // Repository 테스트
        @Test
        void contextLoad1() throws Exception {
                JpaSpecificationBuilder<World> query = JpaSpecificationBuilder
                                .of(World.class);
                query.where()
                                .and().eq("name", "ubisam")
                                .or().like("phoneNumber", "12345678");
                // select * from hello where name = '홍길동' or email like 'abc@abc.com'
                // ==============================================
                // select * from hello where
                // (name = '홍길동' and email like 'abc@abc.com')
                // or (email like 'abc2@abc.com')
                // query.where()
                // .andStart().and().eq("name", "홍길동")
                // .and().like("email", "abc@abc.com").andEnd()
                // .or().like("email", "abc2@abc.com");

                worldRepository.findAll(query.build());
        }

        // Web 요청 테스트
        @Test
        void contextLoad2() throws Exception {

                // Create
                World w = new World();
                // w.setId(2L);
                w.setName("ubisam");
                w.setPhoneNumber("1234");
                w.setKeyword("comany");
                System.out.println(w);

                System.out.println("CreateCreateCreateCreate");
                mockMvc.perform(post("/api/worlds")
                                .content(w))
                                .andDo(print())
                                .andExpect(is2xx());

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
                System.out.println("PutPutPutPutPut");
                w.setName("ubisam2");
                w.setPhoneNumber("5678");
                mockMvc.perform(put("/api/worlds/1").content(w)).andDo(print()).andExpect(is2xx());

                // // Delete
                mockMvc.perform(delete("/api/worlds/1")).andDo(print()).andExpect(is2xx());

        }
}
