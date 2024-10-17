package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    PassengerDto createPassenger(PassengerDto dto);

    PassengerDto getPassengerById(Long passengerId);

    List<PassengerDto> getAllPassengers();
}
