package com.example.Meeting.Config;

import com.example.Meeting.Service.ChatMessageService;
import com.example.Meeting.dto.ChatRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// 메시지 핸들링하는 클래스 - 실시간 통신 구현 위해서
@Component
@Slf4j
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler {
    List<HashMap<String, Object>> rls = new ArrayList<>(); // 웹소켓 세션 담아둘 리스트 - roomList
    private final ChatMessageService chatMessageService;


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 메세지 발송
        String msg = message.getPayload(); // Json 형태 String 메시지 받기
        try {
            JSONObject obj = new JSONObject(msg); // json 데이터 -> jsonObjcet로 파싱하기
            ChatRequestDTO.ChatMessageDTO chatMessageDTO = ChatRequestDTO.ChatMessageDTO.builder()
                    .userName(obj.getString("userName"))
                    .msg(obj.getString("msg"))
                    .id(obj.getLong("Id"))
                    .build();
            chatMessageService.save(chatMessageDTO);

            String rN = (String) obj.get("Id"); // 방 번호 받기
            HashMap<String, Object> temp = new HashMap<String, Object>();
            if(rls.size() > 0) {

            }

        }
        catch (JSONException ex) {
            log.error("Error parsing JSON: {}", ex.getMessage());
        }
    }
}
