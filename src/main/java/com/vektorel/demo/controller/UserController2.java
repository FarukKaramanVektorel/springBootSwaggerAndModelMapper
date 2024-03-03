package com.vektorel.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vektorel.demo.dto.UserDto;
import com.vektorel.demo.service.UserService2;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user2")

public class UserController2 {

	private final UserService2 service;
	private final ModelMapper modelMapper;

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody UserDto userDto) {
		service.add(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getByAll() {
		List<UserDto> users = service.getByAll();
		return ResponseEntity.ok(users);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<String> update(@PathVariable Long userId, @RequestBody UserDto updatedUserDto) {
		try {
			service.update(userId, updatedUserDto);
			return ResponseEntity.ok("User updated successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> delete(@PathVariable Long userId) {
		try {
			service.delete(userId);
			return ResponseEntity.ok("User deleted successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getById(@PathVariable Long userId) {
		UserDto user = service.getById(userId);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
