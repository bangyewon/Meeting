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
        private Long id;
        private String roomName;

        public AddChatRoomDTO(ChatRoomVO chatRoomVO) {
            this.id = chatRoomVO.getId();
            this.roomName = chatRoomVO.getRoomName();
        }
    }
    @Getter // 채팅방 조회
    public static class findChatRoomDTO {
        private Long id;
        private String roomName;

        public findChatRoomDTO(ChatRoomVO chatRoomVO) {
            this.id = chatRoomVO.getId();
            this.roomName = chatRoomVO.getRoomName();
        }
    }
    @Getter // 채팅방 내부 조회
    public static class ChatRoomDTO {
        private Long id;
        private String userName;
        private String msg;
        private String messageCreatedDate;

        public ChatRoomDTO(ChatRoomVO chatRoomVO, String msg,String messageCreatedDate) {
            this.id = chatRoomVO.getId();
            this.msg = msg;
            this.userName = getUserName();
            this.messageCreatedDate = messageCreatedDate;
        }
    }
    //채팅방 메세지 전송
    @Getter
    @Setter
    public static class SendMessageResponseDTO {
        private Long messageId;
        private String userName;
        private String message;
        private String sentDate;

        public SendMessageResponseDTO(Long messageId, String userName, String message, String sentDate) {
            this.messageId = messageId;
            this.userName = userName;
            this.message = message;
            this.sentDate = sentDate;
        }
    }

}
