package com.example.demo.payload;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class CategoryDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String cTitle;
	private String cDesc;
	public int getId() {
		return id;
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
	public CategoryDto(int id, String cTitle, String cDesc) {
		super();
		this.id = id;
		this.cTitle = cTitle;
		this.cDesc = cDesc;
	}
	public CategoryDto() {
		super();
	}
	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", cTitle=" + cTitle + ", cDesc=" + cDesc + ", getId()=" + getId()
				+ ", getcTitle()=" + getcTitle() + ", getcDesc()=" + getcDesc() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
