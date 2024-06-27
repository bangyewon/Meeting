package com.example.Meeting.Service;

import com.example.Meeting.Repository.ChatMessageRepository;
import com.example.Meeting.Repository.UserRepository;
import com.example.Meeting.domain.chat.Chat;
import com.example.Meeting.dto.ChatRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// 채팅방 메시지 저장
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final UserRepository userRepository;

    @Transactional // 저장하기
    public void save(ChatRequestDTO.ChatMessageDTO chatMessageDTO) {
        Chat chat = chatMessageDTO.toEntity();
        chatMessageRepository.save(chat);
    }
}
