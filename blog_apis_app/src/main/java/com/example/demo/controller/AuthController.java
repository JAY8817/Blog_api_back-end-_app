package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiException;
import com.example.demo.payload.JwtAuthRequest;
import com.example.demo.payload.JwtAuthResponse;
import com.example.demo.payload.UserDto;
import com.example.demo.security.JwtTokenHelper;
import com.example.demo.service.UserServices;
import com.example.demo.service.impl.UserServiceImpl;



@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtTokenHelper helper;
	
	@Autowired
	private UserServices userServices;

//    private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody JwtAuthRequest request) {

		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

		String token = this.helper.generateToken(userDetails);
		
		System.out.println(token);

		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);

		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			System.out.println("sjchbhs");
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new ApiException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}
	
	@PostMapping("/Register")
	public ResponseEntity<UserDto> RegisRegisterNewUserterNewUser(@RequestBody UserDto userDto){
		UserDto registerNewUser = this.userServices.RegisterNewUser(userDto);
		return new ResponseEntity<UserDto>(registerNewUser,HttpStatus.CREATED);
	}

}
