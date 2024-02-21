package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.Apiresponce;
import com.example.demo.payload.UserDto;
import com.example.demo.service.UserServices;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServices userServices;

	// post

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto user = this.userServices.createUser(userDto);

		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
		 UserDto userById = this.userServices.getUserById(id);
		return ResponseEntity.ok(userById);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> allUser = this.userServices.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> putMethodName(@Valid @PathVariable Integer id, @RequestBody UserDto userDto) {
		UserDto updateUser = this.userServices.updateUser(userDto, id);
		
		return ResponseEntity.ok(updateUser);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Apiresponce> deleteUser(@PathVariable Integer id){
		
	this.userServices.deleteUser(id);
	return new ResponseEntity<Apiresponce>(new Apiresponce("User deleted sucessfully...",true),HttpStatus.OK);
		
		
	}

}
