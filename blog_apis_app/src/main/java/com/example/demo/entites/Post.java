package com.example.demo.entites;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String title;
	private String content;
	private String imgname;
	private Date date;
	
	@ManyToOne
	public Category category;
	
	@ManyToOne
	public User user;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

	public int getId() {
		return id;
	}

	
	public Set<Comment> getComments() {
		return comments;
	}

	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post(int id, String title, String content, String imgname, Date date, Category category, User user,
			Set<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgname = imgname;
		this.date = date;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}


	public Post() {
		// TODO Auto-generated constructor stub
	}

	


	

	
	

}
