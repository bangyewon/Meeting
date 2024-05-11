package com.example.Meeting.Service;

import com.example.Meeting.Repository.UserRepository;
import com.example.Meeting.Web.UserRequestDTO;
import com.example.Meeting.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void CreateUser(UserRequestDTO userRequestDTO) throws Exception {
      User newUser = userRequestDTO.toEntity();
        //User 파라미터로 이미 있는 사용자 확인하기 ->findByUserId로
        User existingUser = userRepository.findUserById(newUser.getId());
        if(existingUser == null) {
            userRepository.save(newUser);
        }
        else {
            throw new Exception("이미 존재하는 유저");
        }

    }
}
