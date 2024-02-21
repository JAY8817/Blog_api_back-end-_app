package com.example.demo.service;

import com.example.demo.payload.CategoryDto;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CategoryServices {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

	void deleteCategory(Integer id);

	CategoryDto getCategoryById(Integer id);

	List<CategoryDto> getAllCategoryes();

}
