package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.utils.ConvertUser;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserDto create(UserDto userDto) {
		userRepository.save(new ConvertUser().toEntity(userDto));
		return userDto;
	}

	public UserDto update(String id, UserDto userDto) {
		Optional<UserEntity> userToUpdated = userRepository.findById(id);
		if (userToUpdated.isPresent()) {
			UserEntity result = userToUpdated.get();
			userRepository.save(new ConvertUser().toEntity(userDto, result));
			return userDto;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user with id %s does not exist", id));
		}
	}

	public List<UserEntity> getAll() {
		List<UserEntity> usersEntities = userRepository.findAll();
		//List<UserDto> usersDtos = new ArrayList<UserDto>();;
		//for (UserEntity user : usersEntities) {	
		//	usersDtos.add(new ConvertUser().toDto(user));
		//}
		//return usersDtos;
		return usersEntities;
	}
	
	public UserDto get(String id) {
		Optional<UserEntity> result = userRepository.findById(id);
		if (result.isPresent()) {
			UserEntity user = result.get();
			return new ConvertUser().toDto(user);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user with id %s does not exist", id));
		}
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
}
