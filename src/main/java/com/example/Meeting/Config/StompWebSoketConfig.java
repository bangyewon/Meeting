package com.example.Meeting.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//webSocketConfigurer 구현위한 설정파일
@Configuration // Bean 등록하기
// 메시지브로커가 중간에서 송수신 관리해줘야 함
@EnableWebSocketMessageBroker // Stomp의 메시지브로커 사용하기 위해 선언하는 어노테이션
public class StompWebSoketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    //configureMessageBroker() : Simple Message Broker를 활성화시킴
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 메시지브로커 -> 클라이언트(현재 채팅방 구독중)
        // 메시지 구독요청 : 메시지 받을때 prefix
        //enableSimpleBroker() : 해당 파라미터의 주소를 가진 클라이언트에게 브로커가 메시지 전달함!
        // 해당 prefixes들을 브로커가 가로채서 클라이언트에게 전달함
        registry.enableSimpleBroker("/queue"); //"/topic" : 1대다 매칭 , "/queue" : 1:1매칭
        // 클라이언트 -> 메시지브로커
        // 송신 요청 : 메시지 보낼때 prefix
        registry.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void  registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // 클라이언트가 서버로 웹소켓 연결하고 싶을때 엔드포인트에 해당 경로 사용
                .setAllowedOriginPatterns("*") // 모든 클라이언트,도메인에서 연결 가능하도록 열어둠(보안 주의)
                .withSockJS(); //일부 웹소켓 지원되지않는 클라이언트들 SockJS로

    }
}
