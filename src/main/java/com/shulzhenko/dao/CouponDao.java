package com.shulzhenko.dao;

import com.shulzhenko.database.TicketDataBase;
import com.shulzhenko.entity.Coupon;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class CouponDao {
    public void create(Coupon coupon) {
        TicketDataBase.getInstance().createCoupon(coupon);
    }

    public boolean findCouponById(Integer couponId) {
        return TicketDataBase.getInstance().findCouponById(couponId);
    }

    public Set<Coupon> findAll() {
        return TicketDataBase.getInstance().findAllCoupon();
    }
}
