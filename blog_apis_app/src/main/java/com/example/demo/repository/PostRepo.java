package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Category;
import com.example.demo.entites.Post;
import com.example.demo.entites.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser (User user);
	List<Post> findByCategory (Category category);
	List<Post> findByTitleContaining(String title);
}
