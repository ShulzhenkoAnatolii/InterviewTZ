package com.shulzhenko.dao;

import com.shulzhenko.database.TicketDataBase;
import com.shulzhenko.entity.CheckIn;
import org.springframework.stereotype.Repository;

@Repository
public class CheckInDao {

    public boolean findByBaggageId (Integer id) {
        return TicketDataBase.getInstance().findByBaggageId(id);
    }

    public boolean createCheckIn(CheckIn checkIn) {
        return TicketDataBase.getInstance().createCheckIn(checkIn);
    }
}
