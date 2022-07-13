package com.shulzhenko.controller;

import com.shulzhenko.entity.Coupon;
import com.shulzhenko.entity.Ticket;
import com.shulzhenko.exception.DiscountException;
import com.shulzhenko.service.CheckInService;
import com.shulzhenko.service.CouponService;
import com.shulzhenko.service.TicketService;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class MainController {

    private final TicketService ticketService;
    private final CheckInService checkInService;
    private final CouponService couponService;

    public MainController(TicketService ticketService, CheckInService checkInService, CouponService couponService) {
        this.ticketService = ticketService;
        this.checkInService = checkInService;
        this.couponService = couponService;
    }

    public void run() {
        init();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("Checking is the ticket free 1");
        System.out.println("Create check-in baggage 2");
        System.out.println("Check the discount 3");
        System.out.println("All Coupons 4");
        System.out.println("if you want exit, please enter 0");
        System.out.print("---> ");
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                findById(reader);
                break;
            case "2":
                createCheckIn(reader);
                break;
            case "3":
                checkDiscount(reader);
                break;
            case "4":
                findAllCoupon(reader);
                break;
        }
        runNavigation();
    }

    private void findById(BufferedReader reader) {
        System.out.println("findById");
        try {
            System.out.print("Please, enter id ---> ");
            Integer id = Integer.parseInt(reader.readLine());
            System.out.print("Ticket = " + ticketService.findById(id));
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void createCheckIn(BufferedReader reader) {
        System.out.println("create Check-In");
        try {
            System.out.print("Please, enter destinationId ---> ");
            Integer destinationId = Integer.parseInt(reader.readLine());
            System.out.print("Please, enter baggageId ---> ");
            Integer baggageId = Integer.parseInt(reader.readLine());
            System.out.println("CheckIn = " + checkInService.create(destinationId, baggageId));
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void checkDiscount(BufferedReader reader) {
        System.out.println("check Discount");
        try {
            System.out.print("Please, enter couponId ---> ");
            Integer couponId = Integer.parseInt(reader.readLine());
            System.out.print("Please, enter price ---> ");
            double price = Double.parseDouble(reader.readLine());
            System.out.println("Final price = " + couponService.getPriceDiscount(couponId, price));
        } catch (IOException | DiscountException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }


    private void findAllCoupon(BufferedReader reader) {
        System.out.println("All Coupon");
        System.out.println(couponService.findAll());
    }

    public void init() {
        ticketService.create(new Ticket(1, 100));
        ticketService.create(new Ticket(2, 150));
        ticketService.create(new Ticket(3, 200));
        ticketService.create(new Ticket(4, 250));
        ticketService.create(new Ticket(5, 150.5));
        ticketService.create(new Ticket(6, 160.5));
        ticketService.create(new Ticket(7, 180.5));
        ticketService.create(new Ticket(8, 210));
        ticketService.create(new Ticket(9, 110));
        ticketService.create(new Ticket(10, 350));
        couponService.create(new Coupon(1));
        couponService.create(new Coupon(2));
        couponService.create(new Coupon(3));
        couponService.create(new Coupon(4));
        couponService.create(new Coupon(5));
        couponService.create(new Coupon(6));
        couponService.create(new Coupon(7));
        couponService.create(new Coupon(8));
        couponService.create(new Coupon(9));
        couponService.create(new Coupon(10));

    }
}
