package com.example.Meeting.Repository;

import com.example.Meeting.domain.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 메시지 db저장
public interface ChatMessageRepository extends JpaRepository<Chat,String> {
    List<Chat> findByRoomId(Long roomId);

    Chat findTopByRoomIdOrderByCreatedTimeDesc(Long roomId);

    List<Chat> findAllByRoomId(Long roomId);
}
