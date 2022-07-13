package com.shulzhenko.service.impl;

import com.shulzhenko.dao.CouponDao;
import com.shulzhenko.entity.Coupon;
import com.shulzhenko.exception.DiscountException;
import com.shulzhenko.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CouponServiceImpl implements CouponService {

    Logger loggerInfo = LoggerFactory.getLogger("info");
    Logger loggerWarn = LoggerFactory.getLogger("warn");

    private final CouponDao couponDao;
    private final double[] DISCOUNT = {0.1,0.5,0.6};

    public CouponServiceImpl(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    @Override
    public void create(Coupon coupon) {
        couponDao.create(coupon);
        loggerInfo.info("Coupon created");
    }

    public double getPriceDiscount (Integer couponId, double price) throws DiscountException {
        if (couponDao.findCouponById(couponId)) {
            loggerInfo.info("discount " + couponId + " found");
            return (1 - DISCOUNT[(int) (Math.random()*(DISCOUNT.length + 1))]) * price;
        }
        loggerWarn.info("discount " + couponId + " not fount");
        throw new DiscountException("discount not fount");
    }

    @Override
    public Set<Coupon> findAll() {
        return couponDao.findAll();
    }
}
