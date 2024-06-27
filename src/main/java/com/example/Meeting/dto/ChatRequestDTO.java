package com.example.Meeting.dto;

import com.example.Meeting.domain.chat.Chat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class ChatRequestDTO {
    @Getter
    public static class AddChatRoomDTO {
        private Long id;
        private String roomName;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class ChatMessageDTO {
        public enum MessageType {
            ENTER,TALK
        }
        private String userName;
        private String msg;
        private MessageType messageType;
        private Long id;

        @Builder // 생성자
        public ChatMessageDTO(String userName,String msg,Long id) {
            this.msg = msg;
            this.userName = userName;
            this.id = id;
        }
        public Chat toEntity() {
            return Chat.builder()
                    .userName(userName)
                    .msg(msg)
                    .id(id)
                    .build();

        }
    }
}
