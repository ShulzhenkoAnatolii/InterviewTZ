package com.shulzhenko.entity;

public class Ticket {
    private Integer ticketId;
    private double priceTicket;

    public Ticket() {
    }

    public Ticket(Integer ticketId, double priceTicket) {
        this.ticketId = ticketId;
        this.priceTicket = priceTicket;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }
}
