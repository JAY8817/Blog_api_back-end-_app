package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.payload.CommentDto;


@Service
public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer Postid);
	void deleteComment(Integer id);

}
