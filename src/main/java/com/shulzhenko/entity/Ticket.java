package com.shulzhenko.entity;

public class Ticket {
    private Long ticketId;
    private double priceTicket;
    private Long destinationId;
    private Long baggageId;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(Long baggageId) {
        this.baggageId = baggageId;
    }
}
