package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.confige.AppConstance;
import com.example.demo.entites.Roles;
import com.example.demo.entites.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.UserDto;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userdto) {

		User dtoToUser = this.DtoToUser(userdto);
		User save = this.userRepo.save(dtoToUser);
		return this.UserToDto(save);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer Id) {
		User user = this.userRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));

		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());

		User save = this.userRepo.save(user);

		return this.UserToDto(save);

	}

	@Override
	public UserDto getUserById(Integer id) {
		User orElseThrow = this.userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return this.UserToDto(orElseThrow);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> all = this.userRepo.findAll();
		List<UserDto> collect = all.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(Integer id) {
		User save = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		this.userRepo.delete(save);
	}

	public User DtoToUser(UserDto userDto) {
		
		User user = this.modelMapper.map(userDto , User.class);
		
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());

		return user;

	}

	public UserDto UserToDto(User user) {
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());

		return userDto;

	}

	@Override
	public UserDto RegisterNewUser(UserDto userDto) {
		
		User user = this.modelMapper.map(userDto, User.class);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		Roles role = this.roleRepo.findById(AppConstance.Normal_User).get();
		 user.getRoles().add(role);
	User save = this.userRepo.save(user);
		
		return this.modelMapper.map(save, UserDto.class);
	}

}
