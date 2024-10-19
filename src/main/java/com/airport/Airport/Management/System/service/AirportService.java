package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.AirportDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {

    ApiResponse<AirportDto> createAirport(AirportDto dto);
    ApiResponse<AirportDto> getAirportById(Long id);
    ApiResponse<AirportDto> updateAirportById(AirportDto dto, Long id);
    ApiResponse<AirportDto> deleteAirportById(Long id);
    ApiResponse<List<AirportDto>> getAllAirports();

}
