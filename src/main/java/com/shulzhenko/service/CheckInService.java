package com.shulzhenko.service;

public interface CheckInService {

    boolean create (Integer destinationId, Integer baggageId);

    boolean findById (Integer id);

}
