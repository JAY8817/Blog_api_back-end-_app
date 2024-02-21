package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Category;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.CategoryDto;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.service.CategoryServices;

@Service
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category map = this.modelmapper.map(categoryDto, Category.class);
		Category save = this.categoryRepo.save(map);
		
		return this.modelmapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
	Category category = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
	  categoryDto.setcTitle(categoryDto.getcTitle());
	  categoryDto.setcDesc(categoryDto.getcDesc());
	  
	  Category save = this.categoryRepo.save(category);

		return this.modelmapper.map(save, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer id) {
		Category delete = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		this.categoryRepo.delete(delete);
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Category getbyid = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		
		return this.modelmapper.map(getbyid, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategoryes() {
		List<Category> all = this.categoryRepo.findAll();
		List<CategoryDto> collect = all.stream().map(category -> this.modelmapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return collect ;
	}
	
	

}
