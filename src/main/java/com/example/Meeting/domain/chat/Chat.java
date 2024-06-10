package com.example.Meeting.domain.chat;
import java.util.List;
import com.example.Meeting.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "chat")
public class Chat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_id")
    private String roomId;
}
