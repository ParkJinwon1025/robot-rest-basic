package com.demo.api.worlds;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.u2ware.common.docs.MockMvcRestDocs;

@Component
public class WorldDocs extends MockMvcRestDocs {

    // json을 만들기 위한 과정
    public Map<String, Object> newEnity(String name) {

        Map<String, Object> world = new HashMap<>();
        world.put("name", name);
        world.put("phoneNumber", super.randomInt());
        world.put("email", super.randomText("") + "@" + super.randomText("") + ".com");
        world.put("address", super.randomText(""));
        return world;
    }

}
