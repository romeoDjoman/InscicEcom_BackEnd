package com.doranco.inscicecom.services.admin.category;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.doranco.inscicecom.dto.CategoryDto;
import com.doranco.inscicecom.model.Category;
import com.doranco.inscicecom.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public Category createCategory(CategoryDto categoryDto) {
		log.info("Creating a new category: {}", categoryDto.getName());
		return categoryRepository.save(
				Category.builder()
						.name(categoryDto.getName())
						.description(categoryDto.getDescription())
						.build()
		);
	}

	public List<Category> getAllCategory() {
		log.info("Fetching all categories.");
		return categoryRepository.findAll();
	}
}
