package com.example.Meeting.Controller.Chat;

import com.example.Meeting.Service.ChatService;
import com.example.Meeting.common.ApiResponse;
import com.example.Meeting.dto.ChatRequestDTO;
import com.example.Meeting.dto.ChatResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {
@Autowired
    private ChatService chatService;

    // 채팅방 목록 조회
    @GetMapping("/roomList")
  public ApiResponse<List<ChatResponseDTO.findChatRoomDTO>> findChatRoom(
          @RequestHeader(value = "user-no", required = false)Long userId) {
        List<ChatResponseDTO.findChatRoomDTO> result = chatService.findAllChatRoom();
        return ApiResponse.success(result);
    }
    // 채팅방 생성
    @PostMapping("/ChatRoom")
    public ApiResponse<ChatResponseDTO.AddChatRoomDTO> addChat(@RequestBody ChatRequestDTO.AddChatRoomDTO addChatRoomDTO ) {
        ChatResponseDTO.AddChatRoomDTO result = chatService.addChatRoom(addChatRoomDTO);
        return ApiResponse.success(result);
    }

}