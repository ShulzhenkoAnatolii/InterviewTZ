package com.shulzhenko.database;

import com.shulzhenko.entity.CheckIn;
import com.shulzhenko.entity.Coupon;
import com.shulzhenko.entity.Ticket;

import java.util.*;

public class TicketDataBase {

    private List<Ticket> tickets;
    private Set<Coupon> coupons;
    private List<CheckIn> checkIns;
    private static TicketDataBase instance;

    private TicketDataBase() {
        tickets = new ArrayList<>();
        coupons = new LinkedHashSet<>();
        checkIns = new ArrayList<>();
    }

    public static TicketDataBase getInstance() {
        if (instance == null) {
            instance = new TicketDataBase();
        }
        return instance;
    }

    public boolean findById(Integer id) {
        return tickets.stream().anyMatch(x -> x.getTicketId().equals(id));
    }

    public void create(Ticket ticket) {
        tickets.add(ticket);
    }

    public boolean findByBaggageId (Integer id) {
        return checkIns.stream().anyMatch(x -> x.getBaggageId().equals(id));
    }

    public boolean createCheckIn(CheckIn checkIn) {
        if (!findByBaggageId(checkIn.getBaggageId())) {
            checkIns.add(checkIn);
            return true;
        }
        return false;
    }

    public void createCoupon(Coupon coupon) {
        coupons.add(coupon);
    }

    public boolean findCouponById(Integer couponId) {
        return coupons.stream().anyMatch(x -> x.getCouponId().equals(couponId));
    }

    public Set<Coupon> findAllCoupon() {
        return coupons;
    }
}
