package com.example.Meeting.Web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserLoginDTO {
        @NotEmpty
        private String loginId;
        @NotEmpty
        private String password;
}

