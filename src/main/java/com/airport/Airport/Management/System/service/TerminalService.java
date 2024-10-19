package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TerminalDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TerminalService {

    ApiResponse<TerminalDto> createTerminal(TerminalDto dto);
    ApiResponse<TerminalDto> getTerminalById(Long id);
    ApiResponse<TerminalDto> updateTerminalById(TerminalDto dto, Long id);
    ApiResponse<TerminalDto> deleteTerminalById(Long id);
    ApiResponse<List<TerminalDto>> getAllTerminals();
}
