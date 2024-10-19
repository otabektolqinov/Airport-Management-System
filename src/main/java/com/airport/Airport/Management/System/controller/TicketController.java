package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TicketDto;
import com.airport.Airport.Management.System.model.Ticket;
import com.airport.Airport.Management.System.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ApiResponse<TicketDto> createTicket(@RequestBody TicketDto dto) {
        return this.ticketService.createTicket(dto);
    }

    @GetMapping
    public ApiResponse<TicketDto> getTicketById(@RequestParam("id") Long id) {
        return this.ticketService.getTicketById(id);
    }

    @PutMapping
    public ApiResponse<TicketDto> updateTicketById(@RequestParam("id") Long id, @RequestBody TicketDto dto) {
        return this.ticketService.updateTicketById(id, dto);
    }

    @DeleteMapping
    public ApiResponse<TicketDto> deleteTicketById(@RequestParam("id") Long id) {
        return this.ticketService.deleteTicketById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-all")
    public ApiResponse<List<TicketDto>> getAllTickets() {
        return this.ticketService.getAllTicket();
    }
}
