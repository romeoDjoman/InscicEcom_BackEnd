package com.doranco.inscicecom.services.customer.review;

import java.io.IOException;

import com.doranco.inscicecom.dto.OrderedProductsResponseDto;
import com.doranco.inscicecom.dto.ReviewDto;

public interface ReviewService {
	OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
	
	ReviewDto giveReview(ReviewDto reviewDto) throws IOException ;
}
