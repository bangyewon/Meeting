package com.example.Meeting.Service;

import com.example.Meeting.Web.UserRequestDTO;
import com.example.Meeting.domain.User;

public class UserService {
  public void CreateUser(UserRequestDTO userRequestDTO) {
      User newUser = userRequestDTO.toEntity();
  }
}
