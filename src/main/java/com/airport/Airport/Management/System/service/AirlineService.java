package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.AirlineDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirlineService {

    ApiResponse<AirlineDto> createAirline(AirlineDto dto);
    ApiResponse<AirlineDto> getAirlineById(Long id);
    ApiResponse<AirlineDto> updateAirlineById(AirlineDto dto, Long id);
    ApiResponse<AirlineDto> deleteAirlineById(Long id);
    ApiResponse<List<AirlineDto>> getAllAirlines();
}
