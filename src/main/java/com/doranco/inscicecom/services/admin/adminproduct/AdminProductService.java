package com.doranco.inscicecom.services.admin.adminproduct;

import com.doranco.inscicecom.dto.ProductDto;
import io.jsonwebtoken.io.IOException;

import java.util.List;

public interface AdminProductService {

    ProductDto addProduct(ProductDto productDto) throws Exception;

    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductsByName(String name);

    boolean deleteProduct(Long id);

    ProductDto getProductById(Long productId);

    ProductDto updateProduct(Long productId, ProductDto productDto) throws IOException;
}
