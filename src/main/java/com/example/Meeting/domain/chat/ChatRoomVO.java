package com.example.Meeting.domain.chat;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "chatroom")
public class ChatRoomVO {
    // 키
    private Long roomId;
    // 수신자
    private String user1Id;
    // 송신자
    private String user2Id;
    // 방 이름
    private String roomName;
}
