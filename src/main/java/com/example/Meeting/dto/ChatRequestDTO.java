package com.example.Meeting.dto;

import com.example.Meeting.domain.chat.Chat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class ChatRequestDTO {
    @Getter
    public static class  AddChatRoomDTO {
        private Long roomId;
        private String roomName;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public class ChatMessageDTO {
        public enum MessageType {
            ENTER,TALK
        }
        private String userName;
        private String msg;
        private Long roomId;

        @Builder // 생성자
        public ChatMessageDTO(String userName,String msg,Long roomId) {
            this.msg = msg;
            this.userName = userName;
            this.roomId = roomId;
        }
        public Chat toEntity() {
            return Chat.builder()
                    .userName(userName)
                    .msg(msg)
                    .roomId(roomId)
                    .build();

        }
    }
}
