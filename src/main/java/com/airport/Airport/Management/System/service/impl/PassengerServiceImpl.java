package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.PassengerDto;
import com.airport.Airport.Management.System.service.PassengerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerServiceImpl implements PassengerService {
    @Override
    public PassengerDto createPassenger(PassengerDto dto) {
        return null;
    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
        return null;
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        return List.of();
    }
}
