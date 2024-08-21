package com.doranco.inscicecom.services.customer.cart;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.doranco.inscicecom.dto.AddProductInCartDto;
import com.doranco.inscicecom.dto.OrderDto;
import com.doranco.inscicecom.dto.PlaceOrderDto;

public interface CartService {
	ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

	OrderDto getCartByUserId(Long userId);
	
	OrderDto applyCoupon(Long userId,String code);
	
	OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto placedOrder(PlaceOrderDto placeOrderDto);
	
	List<OrderDto> getMyPlacedOrders(Long userId);
	
	OrderDto searchOrderByTrackingId(UUID trackingId);
}
