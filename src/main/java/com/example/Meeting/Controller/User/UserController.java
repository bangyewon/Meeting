package com.example.Meeting.Controller.User;

import com.example.Meeting.Web.UserRequestDTO;
import com.example.Meeting.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @PostMapping("/user")
    public void CreateUser(UserRequestDTO userRequestDTO) {

    }
}
