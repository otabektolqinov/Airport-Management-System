package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    ApiResponse<FlightDto> createFlight(FlightDto dto);

    ApiResponse<FlightDto> getFlightById(Long id);

    ApiResponse<FlightDto> deleteFlightById(Long id);

    ApiResponse<FlightDto> updateFlight(Long id, FlightDto dto);

    ApiResponse<List<FlightDto>> getAllFlights();
}
