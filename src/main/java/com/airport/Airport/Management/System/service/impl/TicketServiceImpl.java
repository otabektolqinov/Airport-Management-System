package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TicketDto;
import com.airport.Airport.Management.System.model.Ticket;
import com.airport.Airport.Management.System.repository.TicketRepository;
import com.airport.Airport.Management.System.service.TicketService;
import com.airport.Airport.Management.System.service.mapper.TicketMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    @Override
    public ApiResponse<TicketDto> createTicket(TicketDto dto) {
        Ticket entity = this.ticketMapper.toEntity(dto);
        Ticket savedTicket = this.ticketRepository.save(entity);
        return ApiResponse.<TicketDto>builder()
                .success(true)
                .message("Ok")
                .content(this.ticketMapper.toDto(savedTicket))
                .build();
    }

    @Override
    public ApiResponse<TicketDto> getTicketById(Long id) {
        Ticket entity = this.ticketRepository.findById(id).orElse(null);
        if (entity == null) {
            return ApiResponse.<TicketDto>builder()
                    .success(false)
                    .message("Not found")
                    .code(-2)
                    .build();
        }
        return ApiResponse.<TicketDto>builder()
                .success(true)
                .message("Ok")
                .content(this.ticketMapper.toDto(entity))
                .build();
    }

    @Override
    public ApiResponse<TicketDto> updateTicketById(Long id, TicketDto dto) {
        Optional<Ticket> ticket = this.ticketRepository.findById(id);
        if (ticket.isEmpty()) {
            return ApiResponse.<TicketDto>builder()
                    .success(false)
                    .message("Not found")
                    .code(-2)
                    .build();
        }
        Ticket ticket1 = ticket.get();
        Ticket updated = this.ticketMapper.updateAllTicketFields(ticket1, dto);
        Ticket savedTicket = this.ticketRepository.save(updated);
        return ApiResponse.<TicketDto>builder()
                .success(true)
                .message("Ok")
                .content(this.ticketMapper.toDto(savedTicket))
                .build();
    }

    @Override
    public ApiResponse<TicketDto> deleteTicketById(Long id) {
        Optional<Ticket> byId = this.ticketRepository.findById(id);
        if (byId.isPresent()) {
            this.ticketRepository.delete(byId.get());
            return ApiResponse.<TicketDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.ticketMapper.toDto(byId.get()))
                    .build();
        }

        return ApiResponse.<TicketDto>builder()
                .success(false)
                .message("Not found")
                .code(-2)
                .build();
    }

    @Override
    public ApiResponse<List<TicketDto>> getAllTicket() {
        List<Ticket> tickets = this.ticketRepository.findAll();
        List<TicketDto> ticketDtoArrayList = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketDto dto = this.ticketMapper.toDto(ticket);
            ticketDtoArrayList.add(dto);
        }
        return ApiResponse.<List<TicketDto>>builder()
                .success(true)
                .message("Ok")
                .content(ticketDtoArrayList)
                .build();
    }
}
