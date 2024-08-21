package com.doranco.inscicecom.services.admin.coupon;

import java.util.List;

import com.doranco.inscicecom.model.Coupon;

public interface AdminCouponService {
	Coupon createCoupon(Coupon coupon);
	List<Coupon> getAllCoupon();
}
