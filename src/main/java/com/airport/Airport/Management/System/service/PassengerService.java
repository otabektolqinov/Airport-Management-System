package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    ApiResponse<PassengerDto> createPassenger(PassengerDto dto);

    ApiResponse<PassengerDto> getPassengerById(Long passengerId);

    ApiResponse<List<PassengerDto>> getAllPassengers();

    ApiResponse<PassengerDto> updatePassengerById(Long passengerId, PassengerDto dto);

    ApiResponse<PassengerDto> deletePassengerById(Long passengerId);
}
