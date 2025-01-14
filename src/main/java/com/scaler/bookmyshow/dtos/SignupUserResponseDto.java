package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Shrihari
 */
@Getter
@Setter
public class SignupUserResponseDto {
    private Long userId;

    @Override
    public String toString() {
        return "SignupUserResponseDto{" +
                "userId=" + userId +
                '}';
    }
}
