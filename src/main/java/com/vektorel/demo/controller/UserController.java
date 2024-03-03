package com.vektorel.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vektorel.demo.dto.UserDto;
import com.vektorel.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService service;
	@PostMapping("/add")
	public void add(@RequestBody UserDto user) {
		service.add(user);
	}
	
	@GetMapping("/")
	public List<UserDto> getByAll(){
		return service.getByAll();
	}
	
	@PutMapping("/update/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserDto updatedUserDto) {
        service.update(userId, updatedUserDto);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        service.delete(userId);
    }

    @GetMapping("/{userId}")
    public UserDto getById(@PathVariable Long userId) {
        return service.getById(userId);
    }
}
