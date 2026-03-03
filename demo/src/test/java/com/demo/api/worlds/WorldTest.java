package com.demo.api.worlds;

import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.domain.Hello;
import com.demo.domain.World;

import io.u2ware.common.data.jpa.repository.query.JpaSpecificationBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class WorldTest {

        @Autowired
        private WorldRepository worldRepository;

        @Autowired
        private MockMvc mockMvc;

        @Test
        void contextLoad3() throws Exception {
                JpaSpecificationBuilder<World> query = JpaSpecificationBuilder
                                .of(World.class);
                query.where()
                                .and().eq("name", "홍길동")
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

                Hello h = new Hello();
                h.setKeyword("g");

                mockMvc.perform(post("/api/helloes/search")
                                .content(h))
                                .andDo(print())
                                .andExpect(is2xx());
        }
}
