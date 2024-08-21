package com.doranco.inscicecom.services.customer;

import java.util.List;

import com.doranco.inscicecom.dto.ProductDetailDto;
import com.doranco.inscicecom.dto.ProductDto;

public interface CustomerProductService {
	List<ProductDto> getAllProducts();

	List<ProductDto> getAllProductsByName(String name);
	
	ProductDetailDto getProductDetailById(Long productId);

}
