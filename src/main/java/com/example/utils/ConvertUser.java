package com.example.utils;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;

public class ConvertUser {
	
	public ConvertUser() {
		
	}
	
	public UserDto toDto(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		return userDto;
	}
	
	public UserEntity toEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		return toEntity(userDto, userEntity);
	}
	
	public UserEntity toEntity(UserDto userDto, UserEntity userEntity) {
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(userDto.getPassword());
		return userEntity;
	}

}
