package com.example.Meeting.Web;

import com.example.Meeting.domain.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String username;
    private String passward;
    private String email;
    private String phone;
    private String profileImage;
    private Gender gender;

}
