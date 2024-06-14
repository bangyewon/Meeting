package com.example.Meeting.dto;

import lombok.Getter;

@Getter
public class ChatRequestDTO {
    @Getter
    public static class  AddChatRoomDTO {
        private Long roomId;
        private String roomName;
    }
}
