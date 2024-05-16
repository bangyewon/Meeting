package com.example.Meeting.Service;

import com.example.Meeting.Repository.UserRepository;
import com.example.Meeting.Web.UserLoginDTO;
import com.example.Meeting.Web.UserRequestDTO;
import com.example.Meeting.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    // 유저 생성
    public void CreateUser(UserRequestDTO userRequestDTO) throws Exception {
        User newUser = userRequestDTO.toEntity();
        //User 파라미터로 이미 있는 사용자 확인하기 ->findByUserId로
        User existingUser = userRepository.findUserById(newUser.getId());
        if (existingUser == null) {
            userRepository.save(newUser);
        } else {
            throw new Exception("이미 존재하는 유저");
        }
    }

    // 유저 삭제
    public void DeleteUser(UserRequestDTO userRequestDTO) {
        Long userId = userRequestDTO.getId(); // UserRequestDTO에서 ID 가져오기
        userRepository.deleteById(userId); // 해당 ID를 가진 유저 삭제
    }

    // 사용자 업데이트
    public void UpdateUser(Long userId, UserRequestDTO userRequestDTO) { // 뭔가 UserUpdateDTO로 분리해서 @Setter 쓰면 괜찮을 수도
        User user = userRepository.findUserById(userId); // 레포에서 userid갖고와서 user에 대입
        if (userRequestDTO.getUsername() != null) {
            user.setUsername(userRequestDTO.getUsername()); // User에 setter 어노테이션 안넣는 방법으로 해결해볼 순 없나
        }
        if (userRequestDTO.getEmail() != null) {
            user.setEmail(userRequestDTO.getEmail());
        }
        if (userRequestDTO.getPhone() != null) {
            user.setPhone(userRequestDTO.getPhone());
        }
        if (userRequestDTO.getPassword() != null) {
            user.setPassword(userRequestDTO.getPassword());
        }
        if (userRequestDTO.getGender() != null) {
            // 성별 문자열을 Gender enum형으로 변환해 업데이트
            user.setGender(userRequestDTO.getGender());
        }
        if (userRequestDTO.getProfileImage() != null) {
            user.setProfileImage(userRequestDTO.getProfileImage());
        }
        // 업데이트된 사용자 저장
        userRepository.save(user);
    }

    // 로그인
    // return String 말고 다른 방식으로 리팩토링
    public String login(UserLoginDTO userLoginDTO) {
        Optional<User> loginUser = userRepository.findByLoginId(userLoginDTO.getLoginId());
        // 유저 일치 안하면 에러
        // 로그인유저 없으면 안됨
        if (loginUser.isEmpty()) {
            return "로그인이 실패했습니다.";
        } else {
            // Optinal로 감쌌기에 추출해야함 ?
            User user = loginUser.get(); // Optional에서 사용자 객체 추출
            if(user.getPassword().equals(userLoginDTO.getPassword())) {
                // 비번 일치 -> 로그인 성공
                return "로그인 성공";
            }
            else {
                return "비밀번호가 일치하지 않습니다.";
            }
        }
    }
}


