package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.Apiresponce;

@RestControllerAdvice
public class AllException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Apiresponce> resourcenotfoundException(ResourceNotFoundException ex) {

		String message = ex.getMessage();
		Apiresponce apiresponce = new Apiresponce(message, false);

		return new ResponseEntity<Apiresponce>(apiresponce, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> hanlerMethodArgsnotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field = ((FieldError) error).getField();
			String messgae = error.getDefaultMessage();
			resp.put(field, messgae);

		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<Apiresponce> handelApiException(ApiException ex) {

		String message = ex.getMessage();
		Apiresponce apiresponce = new Apiresponce(message, false);

		return new ResponseEntity<Apiresponce>(apiresponce, HttpStatus.BAD_REQUEST);

	}

}
