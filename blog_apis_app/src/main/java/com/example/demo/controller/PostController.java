package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.confige.AppConstance;
import com.example.demo.entites.Category;
import com.example.demo.entites.PostResponce;
import com.example.demo.payload.Apiresponce;
import com.example.demo.payload.CategoryDto;
import com.example.demo.payload.PostDto;
import com.example.demo.service.PostServices;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostServices postServices;

	// Create Post

	@PostMapping("user/{userID}/category/{categoryID}/post")
	private ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userID,
			@PathVariable Integer categoryID) {
		PostDto postdto = this.postServices.createPost(postDto, userID, categoryID);
		return new ResponseEntity<PostDto>(postdto, HttpStatus.CREATED);

	}

	// Update Post

	@PutMapping("/post/update/{id}")

	private ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer id) {

		PostDto updatePost = this.postServices.updatePost(postDto, id);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}

	// Get post by UserId

	@GetMapping("post/user/{userID}")
	private ResponseEntity<List<PostDto>> getPostByCatId(@PathVariable Integer userID) {

		List<PostDto> postByCatId = this.postServices.getPostByCatId(userID);

		return new ResponseEntity<List<PostDto>>(postByCatId, HttpStatus.OK);

	}

	// Get post by categoryId

	@GetMapping("post/category/{categoryID}")
	private ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer categoryID) {
		List<PostDto> postByCatId = this.postServices.getPostByCatId(categoryID);

		return new ResponseEntity<List<PostDto>>(postByCatId, HttpStatus.OK);

	}

	// Get ALL Post

	@GetMapping("/post")
	private ResponseEntity<PostResponce> getAllPost(
			@RequestParam(value = "pagenumber", defaultValue = AppConstance.Page_Number, required = false) Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = AppConstance.Page_Size, required = false) Integer pagesize,
			@RequestParam(value = "sortBy", defaultValue = AppConstance.Sort_By, required = false) String sortBy,
			@RequestParam(value = "sortdir", defaultValue = AppConstance.Sort_dir, required = false) String sortdir) {
		PostResponce allPost = this.postServices.getAllPost(pagenumber, pagesize, sortBy,sortdir);
		return new ResponseEntity<PostResponce>(allPost, HttpStatus.OK);
	}

	// Get post by Id

	@GetMapping("post/{post_id}")

	private ResponseEntity<PostDto> getPostById(@PathVariable Integer post_id) {
		PostDto postById = this.postServices.getPostById(post_id);

		return ResponseEntity.ok(postById);
	}

	// Delete Post

	@DeleteMapping("post/delete/{id}")
	public ResponseEntity<Apiresponce> deletePost(@PathVariable Integer id) {

		this.postServices.deletePost(id);
		return new ResponseEntity(new Apiresponce("Post deleted sucessfully...", true), HttpStatus.OK);

	}
	
	@GetMapping("post/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost (@PathVariable String keyword){
		List<PostDto> searchPost = this.postServices.searchPost(keyword);
		
		return new ResponseEntity<List<PostDto>>(searchPost,HttpStatus.OK);
		
		
	}

}
