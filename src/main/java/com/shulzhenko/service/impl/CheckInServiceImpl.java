package com.shulzhenko.service.impl;

import com.shulzhenko.dao.CheckInDao;
import com.shulzhenko.entity.CheckIn;
import com.shulzhenko.service.CheckInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckInServiceImpl implements CheckInService {

    Logger loggerInfo = LoggerFactory.getLogger("info");
    Logger loggerWarn = LoggerFactory.getLogger("warn");

    private final CheckInDao checkInDao;

    public CheckInServiceImpl(CheckInDao checkInDao) {
        this.checkInDao = checkInDao;
    }

    @Override
    public boolean create(Integer destinationId, Integer baggageId) {
        if (!findById(baggageId)) {
            CheckIn checkIn = new CheckIn();
            checkIn.setDestinationId(destinationId);
            checkIn.setBaggageId(baggageId);
            checkInDao.createCheckIn(checkIn);
            loggerInfo.info("Check-in ok");
            return true;
        }
        loggerWarn.info("Check-in false, Baggage ID = " + baggageId + " already exists ");
        return false;
    }

    @Override
    public boolean findById(Integer id) {
        return checkInDao.findByBaggageId(id);
    }
}
