package com.shulzhenko.service;

import com.shulzhenko.entity.Ticket;

public interface TicketService {

    void create (Ticket ticket);

    boolean findById (Integer id);

}
