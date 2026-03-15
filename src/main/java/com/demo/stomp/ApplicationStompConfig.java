package com.demo.stomp;

import org.springframework.context.annotation.Configuration;

import io.u2ware.common.stomp.client.config.EnableWebsocketStompClient;

@Configuration
@EnableWebsocketStompClient // 스톰프 클라이언트 가지고 있기
public class ApplicationStompConfig {

}
