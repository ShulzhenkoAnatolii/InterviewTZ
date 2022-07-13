package com.shulzhenko.dao;

import com.shulzhenko.database.TicketDataBase;
import com.shulzhenko.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {

    public boolean findById(Integer id) {
        return TicketDataBase.getInstance().findById(id);
    }

    public void create(Ticket ticket) {
        TicketDataBase.getInstance().create(ticket);
    }
}
