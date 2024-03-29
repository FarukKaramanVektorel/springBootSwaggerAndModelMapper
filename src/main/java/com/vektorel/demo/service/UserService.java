package com.vektorel.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vektorel.demo.dto.UserDto;
import com.vektorel.demo.entity.User;
import com.vektorel.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repository;
	private final ModelMapper modelMapper;
	public void add(UserDto userDto) {
		User user=modelMapper.map(userDto, User.class);
		repository.save(user);
	}

	public List<UserDto> getByAll() {		
		List<User> userList = repository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
	}
	
	public void update(Long userId, UserDto updatedUserDto) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            modelMapper.map(updatedUserDto, existingUser);
            repository.save(existingUser);
        }
    }

    public void delete(Long userId) {
        repository.deleteById(userId);
    }

    public UserDto getById(Long userId) {
        Optional<User> optionalUser = repository.findById(userId);
        return optionalUser.map(user -> modelMapper.map(user, UserDto.class)).orElse(null);
    }

}
