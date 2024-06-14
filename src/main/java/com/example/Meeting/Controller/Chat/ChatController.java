package com.example.Meeting.Controller.Chat;

import com.example.Meeting.Service.ChatService;
import com.example.Meeting.common.ApiResponse;
import com.example.Meeting.domain.chat.ChatRoomVO;
import com.example.Meeting.dto.ChatRequestDTO;
import com.example.Meeting.dto.ChatResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {
@Autowired
    private ChatService chatService;

    // 채팅방 목록 조회
    @GetMapping("/roomList")
    public List<ChatRoomVO> selectRoomList() {
        return new ArrayList<>(chatService.selectRoomList());
    }
    // 채팅방 생성
    @PostMapping("/ChatRoom")
    public ApiResponse<ChatResponseDTO.AddChatRoomDTO> addChat(@RequestBody ChatRequestDTO.AddChatRoomDTO addChatRoomDTO ) {
        ChatResponseDTO.AddChatRoomDTO result = chatService.addChatRoom(addChatRoomDTO);
        return ApiResponse.success(result);
    }

}
