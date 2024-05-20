package com.example.Meeting.Web;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class UserLoginDTO {
        @NotEmpty
        private String email;
        @NotEmpty
        private String password;
}

