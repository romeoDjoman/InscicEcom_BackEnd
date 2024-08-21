package com.doranco.inscicecom.services.customer.wishlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.doranco.inscicecom.dto.WishlistDto;
import com.doranco.inscicecom.model.Product;
import com.doranco.inscicecom.model.User;
import com.doranco.inscicecom.model.Wishlist;
import com.doranco.inscicecom.repository.ProductRepository;
import com.doranco.inscicecom.repository.UserRepository;
import com.doranco.inscicecom.repository.WishlistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishlistServiceImpl implements WishlistService{
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final WishlistRepository wishlistRepository;

	public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
		Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());

		if (optionalProduct.isPresent() && optionalUser.isPresent()) {
			Wishlist wishlist = new Wishlist();
			wishlist.setProduct(optionalProduct.get());
			wishlist.setUser(optionalUser.get());

			log.info("Product with ID {} added to wishlist for user with ID {}", wishlistDto.getProductId(), wishlistDto.getUserId());
			return wishlistRepository.save(wishlist).getWishlistDto();
		}
		log.error("Failed to add product to wishlist. Product or user not found.");
		return null;
	}

	public List<WishlistDto> getWishlistByUserId(Long userId){
		List<Wishlist> wishlist = wishlistRepository.findAllByUserId(userId);
		log.info("Retrieved wishlist for user with ID {}", userId);
		return wishlist.stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
	}
}
