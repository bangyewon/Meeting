package com.example.Meeting.domain.chat;

import com.example.Meeting.common.BaseEntity;
import com.example.Meeting.domain.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private ChatRoomVO chatRoomVO;

    private String content;

    private LocalDateTime timestamp;
}
