package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.AircraftDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AircraftService {

    ApiResponse<AircraftDto> createAircraftDto(AircraftDto dto);
    ApiResponse<AircraftDto> getAircraftById(Long id);
    ApiResponse<AircraftDto> updateAircraftById(AircraftDto dto, Long id);
    ApiResponse<AircraftDto> deleteAircraftById(Long id);
    ApiResponse<List<AircraftDto>> getAllAircrafts();

}
