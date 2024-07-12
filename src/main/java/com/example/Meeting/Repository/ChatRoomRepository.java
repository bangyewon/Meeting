package com.example.Meeting.Repository;

import com.example.Meeting.domain.chat.ChatRoomVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomVO, Long> {
    List<ChatRoomVO> findAll();
}
