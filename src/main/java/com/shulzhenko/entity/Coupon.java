package com.shulzhenko.entity;

public class Coupon {
    private Integer couponId;

    public Coupon() {
    }

    public Coupon(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        return "All Coupon{" +
                "couponId=" + couponId +
                '}';
    }
}
