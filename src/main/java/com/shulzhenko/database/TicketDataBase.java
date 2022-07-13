package com.shulzhenko.database;

import com.shulzhenko.entity.Coupon;
import com.shulzhenko.entity.Ticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TicketDataBase {

    private List<Ticket> tickets;
    private Set<Coupon> coupons;
    private static TicketDataBase instance;

    private TicketDataBase() {
        tickets = new ArrayList<>();
        coupons = new HashSet<>();
    }

    public static TicketDataBase getInstance() {
        if (instance == null) {
            instance = new TicketDataBase();
        }
        return instance;
    }

    public void createTicket (Ticket ticket) {
        ticket.setTicketId(ticket.getTicketId());
        ticket.setDestinationId(ticket.getDestinationId());
        ticket.setBaggageId(ticket.getBaggageId());
        ticket.setPriceTicket(ticket.getPriceTicket());
        tickets.add(ticket);
    }

    public boolean findById(Long id) {
        return tickets.stream().anyMatch(x -> x.getTicketId().equals(id));
    }
}
