package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.Apiresponce;
import com.example.demo.payload.CategoryDto;
import com.example.demo.service.CategoryServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryServices categoryServices;

	@PostMapping("/")
	private ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto category = this.categoryServices.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
		CategoryDto categoryDto = this.categoryServices.getCategoryById(id);
		return ResponseEntity.ok(categoryDto);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategoryes() {
		List<CategoryDto> allUser = this.categoryServices.getAllCategoryes();
		return ResponseEntity.ok(allUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer id,
			@RequestBody CategoryDto categoryDto) {
		CategoryDto updateUser = this.categoryServices.updateCategory(categoryDto, id);

		return ResponseEntity.ok(updateUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Apiresponce> deleteUser(@PathVariable Integer id) {

		this.categoryServices.deleteCategory(id);
		return new ResponseEntity(new Apiresponce("Category deleted sucessfully...", true), HttpStatus.OK);

	}

}
