package com.demo.stomp.ubisam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.api.helloes.HelloRepository;
// import com.demo.domain.Hello;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.u2ware.common.stomp.client.WebsocketStompClient;
import io.u2ware.common.stomp.client.WebsocketStompClientHandler;
import io.u2ware.common.stomp.client.config.WebsocketStompProperties;

@Component
public class UbisamSubscriber implements WebsocketStompClientHandler {

    @Autowired
    public WebsocketStompProperties properties;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    public HelloRepository helloRepository;

    @Override
    public void handleFrame(WebsocketStompClient client, JsonNode message) {
        System.out.println("Received Message : " + message.toString());

        // 메시지 정의
        // ObjectNode data = objectMapper.createObjectNode();
        // data.put("message", "Hello1");

        // 로봇에게 보내기
        // client.send("/app/robot", data);

        // Hello h = new Hello();
        // h.setName(message.toString());
        // helloRepository.save(h);

        ObjectNode data = objectMapper.createObjectNode();
        data.put("type", "request");
        data.put("targetX", 10.0);
        data.put("targetY", 20.0);
        client.send("/app/robot", data);

    }

    @Override
    public String getDestination() {

        // 유비샘을 구독한 클라이언트 (이 클래스 코드가 실행됨.)
        return properties.getSubscriptions().get("ubisam");
    }

}
