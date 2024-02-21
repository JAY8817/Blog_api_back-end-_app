package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.payload.UserDto;

@Service
public interface UserServices {
	
	UserDto RegisterNewUser(UserDto userDto);
	UserDto createUser(UserDto userdto);
	UserDto updateUser(UserDto userdto,Integer Id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUser();
	void deleteUser(Integer id);
	
	
	
	

}
