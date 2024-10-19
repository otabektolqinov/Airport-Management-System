package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.GateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GateService {

    ApiResponse<GateDto> createGate(GateDto dto);
    ApiResponse<GateDto> getGateById(Long id);
    ApiResponse<GateDto> updateGateById(GateDto dto, Long id);
    ApiResponse<GateDto> deleteGateById(Long id);
    ApiResponse<List<GateDto>> getAllGates();
}
