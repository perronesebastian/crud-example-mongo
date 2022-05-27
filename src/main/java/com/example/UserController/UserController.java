package com.example.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.create(userDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@PathVariable("id") String id, @RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.update(id, userDto), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAll() {
		return new ResponseEntity<List<UserEntity>>(userService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> get(@PathVariable("id") String id) {
		return new ResponseEntity<UserDto>(userService.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		userService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
	

