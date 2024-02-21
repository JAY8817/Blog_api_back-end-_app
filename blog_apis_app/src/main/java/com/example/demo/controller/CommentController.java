package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.Apiresponce;
import com.example.demo.payload.CommentDto;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/post/{Postid}/")
	public  ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer Postid){
		CommentDto comment = this.commentService.createComment(commentDto, Postid);
		
		
		return new ResponseEntity<CommentDto>(comment,HttpStatus.OK);
	}
	
	
	@DeleteMapping("comments/{id}")
	public  ResponseEntity<Apiresponce> deleteComment(@PathVariable Integer id){
		this.commentService.deleteComment(id);
		return new ResponseEntity<Apiresponce>(new Apiresponce("Comment deleted sucessfully...",true),HttpStatus.OK);
		
	}
	
	

}
