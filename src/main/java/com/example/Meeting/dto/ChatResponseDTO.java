package com.example.Meeting.dto;

import com.example.Meeting.domain.chat.ChatRoomVO;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ChatResponseDTO {
    // 채팅방 생성
    @Getter
    @Setter
    public static class AddChatRoomDTO {
        private Long roomId;
        private String roomName;

        public AddChatRoomDTO(ChatRoomVO chatRoomVO) {
            this.roomId = chatRoomVO.getRoomId();
            this.roomName = chatRoomVO.getRoomName();
        }
    }
    @Getter
    public static class findChatRoomDTO {
        private Long roomId;
        private String roomName;

        public findChatRoomDTO(ChatRoomVO chatRoomVO) {
            this.roomId = chatRoomVO.getRoomId();
            this.roomName = chatRoomVO.getRoomName();
        }
    }
}
