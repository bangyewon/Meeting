package com.example.Meeting.Controller.User;

import com.example.Meeting.Service.UserService;
import com.example.Meeting.Web.UserLoginDTO;
import com.example.Meeting.Web.UserRequestDTO;
import com.example.Meeting.domain.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

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
//    @PostMapping("/delete/{userId}")
//    public ResponseEntity<String> logout() {
//
//    }
    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 비밀번호,로그인 id 맞는지 확인
//       User user =  UserService.login(userLoginDTO.getLoginId(),userLoginDTO.getPassword()); 이미 Service에서 확인함
        User user = userService.login(userLoginDTO);
       if(user != null) {
           // session 생성 -> 성공 시 redirect로 홈화면으로 돌아가게
           HttpSession session = request.getSession();
           session.setAttribute("user", user);
           // 응답 설정
           response.setStatus(HttpServletResponse.SC_OK);
           response.sendRedirect("/main");  // 리디렉션 URL 설정해서 로그인 시 돌아가도록 설정
           return ResponseEntity.ok("로그인 성공");
       }else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
       }

    }
    @PostMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserRequestDTO userRequestDTO) {
        userService.UpdateUser(userId, userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User updated successfully.");
    }
}
