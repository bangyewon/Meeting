package com.example.Meeting.Web;

import com.example.Meeting.domain.User.Gender;
import com.example.Meeting.domain.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private Long id; // 유저 삭제 위함
    private String username;
    private String password;
    private String email;
    private String phone;
//    private String profileImage;
    private Gender gender;

    public User toEntity() {
        return User.builder()
                .email(email)
                .phone(phone)
                .password(password)
                .username(username)
                .gender(gender)
                .build();
    }
}
