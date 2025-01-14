package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.SignupUserRequestDto;
import com.scaler.bookmyshow.dtos.SignupUserResponseDto;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: Shrihari
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupUserResponseDto signupUser(SignupUserRequestDto signupUserRequestDto) {
        SignupUserResponseDto signupUserResponseDto = new SignupUserResponseDto();
        User user = userService.signupUser(signupUserRequestDto.getEmail(), signupUserRequestDto.getPassword());
        signupUserResponseDto.setUserId(user.getId());
        return signupUserResponseDto;
    }
}
