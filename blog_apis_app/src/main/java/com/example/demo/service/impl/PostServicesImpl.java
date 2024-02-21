package com.example.demo.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Category;
import com.example.demo.entites.Post;
import com.example.demo.entites.PostResponce;
import com.example.demo.entites.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.PostDto;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.PostRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.PostServices;

@Service
public class PostServicesImpl implements PostServices {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer Userid, Integer Catid) {

		User userfind = this.userRepo.findById(Userid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", Userid));
		Category catfind = this.categoryRepo.findById(Catid)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", Catid));

		Post post = this.modelMapper.map(postDto, Post.class);

		post.setImgname("defult.png");
		post.setDate(new Date(1));
		post.setCategory(catfind);
		post.setUser(userfind);
		Post save = this.postRepo.save(post);

		return this.modelMapper.map(save, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImgname(postDto.getImgname());

		Post save = this.postRepo.save(post);

		return this.modelMapper.map(save, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer id) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponce getAllPost(Integer pagenumber , Integer pagesize,String sortBy,String sortdir) {

		Sort sort = sortdir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

		Pageable page = PageRequest.of(pagenumber, pagesize,sort);

		Page<Post> all = this.postRepo.findAll(page);
		List<Post> content = all.getContent();
		List<PostDto> collect = content.stream().map(e -> this.modelMapper.map(e, PostDto.class))
				.collect(Collectors.toList());
		PostResponce ps = new PostResponce();
		ps.setContent(collect);
		ps.setPagenumber(all.getNumber());
		ps.setPagesize(all.getSize());
		ps.setLastpage(all.isLast());
		ps.setTotalelement(all.getTotalElements());
		ps.setTotalpages(all.getTotalPages());
		
		return ps;
	}


	@Override
	public void deletePost(Integer id) {
		Post byId = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		this.postRepo.delete(byId);

	}

	@Override
	public List<PostDto> getPostByCatId(Integer catId) {
		Category findbycat = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", catId));
		List<Post> post = this.postRepo.findByCategory(findbycat);
		List<PostDto> collect = post.stream().map(e -> this.modelMapper.map(e, PostDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public List<PostDto> getPostByUserId(Integer userId) {
		User findbyuser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		List<Post> byUser = this.postRepo.findByUser(findbyuser);
		List<PostDto> collect = byUser.stream().map(e -> this.modelMapper.map(e, PostDto.class))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> search = this.postRepo.findByTitleContaining(keyword);
		List<PostDto> collect = search.stream().map(e->this.modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

}
