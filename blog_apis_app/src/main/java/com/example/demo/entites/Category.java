package com.example.demo.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoryes")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Title",length = 100,nullable = false)
	private String cTitle;
	
	@Column(name = "description")
	private String cDesc;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();

	public int getId() {
		return id;
	}

	public List<Post> getPost() {
		return posts;
	}

	public void setPost(List<Post> post) {
		this.posts = post;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcDesc() {
		return cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}
	

	public Category() {
		super();
	}

	public Category(int id, String cTitle, String cDesc, List<Post> post) {
		super();
		this.id = id;
		this.cTitle = cTitle;
		this.cDesc = cDesc;
		this.posts = post;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", cTitle=" + cTitle + ", cDesc=" + cDesc + ", getId()=" + getId()
				+ ", getcTitle()=" + getcTitle() + ", getcDesc()=" + getcDesc() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	

}
