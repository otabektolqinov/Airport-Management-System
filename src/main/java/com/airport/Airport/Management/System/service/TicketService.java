package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TicketDto;
import com.airport.Airport.Management.System.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    ApiResponse<TicketDto> createTicket(TicketDto dto);

    ApiResponse<TicketDto> getTicketById(Long id);

    ApiResponse<TicketDto> updateTicketById(Long id, TicketDto dto);

    ApiResponse<TicketDto> deleteTicketById(Long id);

    ApiResponse<List<TicketDto>> getAllTicket();

}
