package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	

}
