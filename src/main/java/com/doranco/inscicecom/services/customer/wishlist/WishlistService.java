package com.doranco.inscicecom.services.customer.wishlist;

import java.util.List;

import com.doranco.inscicecom.dto.WishlistDto;

public interface WishlistService {
	WishlistDto addProductToWishlist( WishlistDto wishlistDto);
	
	List<WishlistDto> getWishlistByUserId(Long userId);
}
