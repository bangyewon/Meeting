package com.example.Meeting.domain.chat;

import com.example.Meeting.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "chatroom")
public class ChatRoomVO extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomId;
    // 수신자
    private String user1Id;
    // 송신자
    private String user2Id;
    // 방 이름
    private String roomName;
}
