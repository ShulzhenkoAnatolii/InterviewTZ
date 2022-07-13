package com.shulzhenko.service.impl;

import com.shulzhenko.dao.TicketDao;
import com.shulzhenko.entity.Ticket;
import com.shulzhenko.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    Logger loggerInfo = LoggerFactory.getLogger("info");

    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public void create(Ticket ticket) {
        ticketDao.create(ticket);
        loggerInfo.info("Created Ticket");
    }

    @Override
    public boolean findById(Integer id) {
        loggerInfo.info("FindById ---> id = " + id);
        return ticketDao.findById(id);
    }
}
