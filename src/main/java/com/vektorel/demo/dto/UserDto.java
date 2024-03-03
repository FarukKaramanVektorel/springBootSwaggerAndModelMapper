package com.vektorel.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

	private Long id;
	private String name;
	private String password;
	private String email;

}
