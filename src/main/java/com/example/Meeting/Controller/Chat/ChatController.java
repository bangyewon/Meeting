package com.example.Meeting.Controller.Chat;

import com.example.Meeting.Service.ChatService;
import com.example.Meeting.domain.chat.ChatRoomVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private ChatService chatService;

    // 채팅방 목록 조회
    @GetMapping("/roomList")
    public List<ChatRoomVO> selectRoomList() {
        return new ArrayList<>(chatService.selectRoomList());
    }
}
