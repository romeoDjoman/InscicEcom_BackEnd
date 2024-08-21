package com.doranco.inscicecom.services.admin.category;

import java.util.List;

import com.doranco.inscicecom.dto.CategoryDto;
import com.doranco.inscicecom.model.Category;

public interface CategoryService {
	 Category createCategory(CategoryDto categoryDto);
	 List<Category> getAllCategory();
}
