package com.laptrinhjavaweb.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDTO extends BaseDTO<CustomerDTO> {

	private String firstName;

	private String lastName;

	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDay;

	public CustomerDTO() {

	}

	public CustomerDTO(String firstName, String lastName, String email, LocalDate birthDay) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDay = birthDay;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

}
