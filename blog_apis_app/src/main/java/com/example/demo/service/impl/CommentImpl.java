package com.example.demo.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Comment;
import com.example.demo.entites.Post;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.CommentDto;
import com.example.demo.payload.PostDto;
import com.example.demo.repository.CommentRepo;
import com.example.demo.repository.PostRepo;
import com.example.demo.service.CommentService;

@Service
public class CommentImpl implements CommentService {
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer Postid) {
		Post post = this.postRepo.findById(Postid).orElseThrow(() -> new ResourceNotFoundException("Post", "Postid", Postid));
		Comment comment = this.modelMapper.map(commentDto,Comment.class);
		comment.setPost(post);
		Comment save = this.commentRepo.save(comment);
		
		return this.modelMapper.map(save, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer id) {
		
		Comment comment = this.commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Postid", id));
		
		this.commentRepo.delete(comment);
	}

}
