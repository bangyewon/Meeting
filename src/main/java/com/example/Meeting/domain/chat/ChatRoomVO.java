package com.example.Meeting.domain.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomVO {
    // 키
    private Long roomId;
    // 수신자
    private String user1Id;
    // 송신자
    private String user2Id;
}
