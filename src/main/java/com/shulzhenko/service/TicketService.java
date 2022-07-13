package com.shulzhenko.service;

import com.shulzhenko.entity.Ticket;

public interface TicketService {

    void createTicket (Ticket ticket);

    boolean findById (Long id);

}
