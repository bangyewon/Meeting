package com.example.Meeting.Service;

import com.example.Meeting.Repository.ChatRoomRepository;
import com.example.Meeting.domain.chat.ChatRoomVO;
import com.example.Meeting.dto.ChatRequestDTO;
import com.example.Meeting.dto.ChatResponseDTO;
import com.example.Meeting.exception.DsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    final List<ChatResponseDTO.findChatRoomDTO> roomList = new ArrayList<>();

    // 채팅방 목록 조회
    public List<ChatResponseDTO.findChatRoomDTO> findAllChatRoom() {
        List<ChatRoomVO> chatRoomList = chatRoomRepository.findAll();
        roomList.clear(); // 기존 목록을 초기화
        for (ChatRoomVO chatRoomVO : chatRoomList) {
            roomList.add(new ChatResponseDTO.findChatRoomDTO(chatRoomVO)); // 객체 생성해 저장하기
        }
        return roomList;
    }

    // 채팅방 생성
    public ChatResponseDTO.AddChatRoomDTO addChatRoom(ChatRequestDTO.AddChatRoomDTO addChatRoomDTO) {
        // 유저 확인하고 생성해야할듯 리팩토링 필요
        ChatRoomVO chatRoomVO = new ChatRoomVO();
        chatRoomVO.setRoomName(addChatRoomDTO.getRoomName());
        chatRoomVO.setRoomId((long) roomList.size() + 1); // 고유 roomId 설정
        chatRoomRepository.save(chatRoomVO);

        ChatResponseDTO.AddChatRoomDTO responseDTO = new ChatResponseDTO.AddChatRoomDTO(chatRoomVO);
        responseDTO.setRoomId(chatRoomVO.getRoomId());
        responseDTO.setRoomName(chatRoomVO.getRoomName());

        System.out.println("채팅방이 생성됐습니다.");
        return responseDTO;
    }
}
