package com.example.Meeting.domain.chat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.example.Meeting.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "chat")
public class Chat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "msg")
    private String msg;
    @Column(name = "created_time")
    private String createdTime;
//    @Column(name = "room_id")
//    private Long roomId;

    @Builder
    public  Chat(String msg,String userName,Long id) {
        this.msg = msg;
        this.id = id;
        this.userName = userName;
        this.createdTime = ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
