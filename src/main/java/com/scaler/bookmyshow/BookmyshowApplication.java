package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.TicketController;
import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.dtos.SignupUserRequestDto;
import com.scaler.bookmyshow.dtos.SignupUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
public class BookmyshowApplication implements CommandLineRunner {

	private UserController userController;
	private TicketController ticketController;

	@Autowired
	public BookmyshowApplication(UserController userController, TicketController ticketController) {
		this.userController = userController;
		this.ticketController = ticketController;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// If i want to run something after application has start, the code for that goes here.
//		System.out.println("Hello");
//		SignupUserRequestDto signupUserRequestDto = new SignupUserRequestDto();
//		signupUserRequestDto.setEmail("shriharikulkarni94@gmail.com");
//		signupUserRequestDto.setPassword("Thaiya@123");
//		SignupUserResponseDto signupUserResponseDto = userController.signupUser(signupUserRequestDto);
//		System.out.println(signupUserResponseDto);


		BookTicketRequestDto bookTicketRequestDto = new BookTicketRequestDto();
		bookTicketRequestDto.setSeatIds(new ArrayList<>(Arrays.asList(11L, 12L)));
		bookTicketRequestDto.setUserId(152L);
		bookTicketRequestDto.setShowId(11L);
		BookTicketResponseDto bookTicketResponseDto = ticketController.bookTicket(bookTicketRequestDto);
		System.out.println(bookTicketResponseDto);
	}
}
