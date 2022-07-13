package com.shulzhenko.service;

import com.shulzhenko.entity.Coupon;
import com.shulzhenko.exception.DiscountException;

import java.util.Set;

public interface CouponService {

    void create (Coupon coupon);

    double getPriceDiscount (Integer couponId, double price) throws DiscountException;

    Set<Coupon> findAll();

}
