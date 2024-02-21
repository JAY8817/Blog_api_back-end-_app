package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.PostResponce;
import com.example.demo.payload.PostDto;


public interface PostServices {
	
	PostDto createPost(PostDto postDto,Integer Userid,Integer Catid);
	PostDto updatePost(PostDto postDto,Integer id);
	PostDto getPostById(Integer id);
	PostResponce getAllPost(Integer pagenumber , Integer pagesize ,String sortBy,String sortdir);
	void deletePost(Integer id);
	List<PostDto> getPostByCatId(Integer catId);
	List<PostDto> getPostByUserId(Integer userId);
	List<PostDto> searchPost(String keyword);
	
}
