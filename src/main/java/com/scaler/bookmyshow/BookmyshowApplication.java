package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.dtos.SignupUserRequestDto;
import com.scaler.bookmyshow.dtos.SignupUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowApplication implements CommandLineRunner {

	private UserController userController;

	@Autowired
	public BookmyshowApplication(UserController userController) {
		this.userController = userController;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// If i want to run something after application has start, the code for that goes here.
		System.out.println("Hello");
		SignupUserRequestDto signupUserRequestDto = new SignupUserRequestDto();
		signupUserRequestDto.setEmail("shriharikulkarni94@gmail.com");
		signupUserRequestDto.setPassword("Thaiya@123");
		SignupUserResponseDto signupUserResponseDto = userController.signupUser(signupUserRequestDto);
		System.out.println(signupUserResponseDto);
	}
}
