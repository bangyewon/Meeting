package com.example.Meeting.Web;

import com.example.Meeting.domain.Gender;
import com.example.Meeting.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String profileImage;
    private Gender gender;

    public User toEntity() {
        return User .builder()
                .email(email)
                .phone(phone)
                .password(password)
                .username(username)
                .profileImage(profileImage)
                .build();
    }
}
