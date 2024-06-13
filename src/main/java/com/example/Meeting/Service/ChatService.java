package com.example.Meeting.Service;

import com.example.Meeting.domain.chat.ChatRoomVO;
import com.example.Meeting.exception.DsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    //사용자 list
    private List<String> userList = new ArrayList<>();
    //채팅방 list
    private List<ChatRoomVO> roomList = new ArrayList<>();

    // 방 찾기
    public ChatRoomVO getTargetRoom(ChatRoomVO chatRoomVO) {
        for(int i = 0; i < roomList.size(); i++) {
            if(chatRoomVO.getRoomId() == roomList.get(i).getRoomId()){
                return roomList.get(i);
            }
        }
        throw new DsException("대화방을 찾지 못했습니다.", HttpStatus.NOT_FOUND);
    }
    // 채팅방 목록 조회
    public List<ChatRoomVO> selectRoomList() {
        return roomList;
    }

    // 채팅방 생성
    public Boolean addChatRoom(ChatRoomVO chatRoomVO) {
        roomList.add(chatRoomVO);
        chatRoomVO.setRoomId((long)(roomList.size())); //새로운 채팅방 개설 시 roomid를 roomList.size지정
        System.out.println("채팅방이 생성됐습니다.");
        return true;
    }
}
