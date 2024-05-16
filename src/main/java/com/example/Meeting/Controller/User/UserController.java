package com.example.Meeting.Controller.User;

import com.example.Meeting.Service.UserService;
import com.example.Meeting.Web.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
  public ResponseEntity<String> CreateUser(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        userService.CreateUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully.");
    }
    @PostMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserRequestDTO userRequestDTO) {
        userService.UpdateUser(userId, userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User updated successfully.");
    }
}
