package com.example.demo.payload;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.entites.Comment;



public class PostDto {
	
	
	private int id;
	private String title;
	private String content;
	private String imgname;
	private Date date;
	public  UserDto user;
	public CategoryDto category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	
	public Set<CommentDto> comments= new HashSet<>();
	
	public Set<CommentDto> getComments() {
		return comments;
	}
	
	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}
	public PostDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PostDto(int id, String title, String content, String imgname, Date date, UserDto user, CategoryDto category,
			Set<CommentDto> comments) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgname = imgname;
		this.date = date;
		this.user = user;
		this.category = category;
		this.comments = comments;
	}
	
	
	
	

}
