package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.PassengerDto;
import com.airport.Airport.Management.System.model.Passenger;
import com.airport.Airport.Management.System.model.Ticket;
import com.airport.Airport.Management.System.repository.PassengerRepository;
import com.airport.Airport.Management.System.repository.TicketRepository;
import com.airport.Airport.Management.System.service.PassengerService;
import com.airport.Airport.Management.System.service.mapper.PassengerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerMapper passengerMapper;
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;

    @Override
    public ApiResponse<PassengerDto> createPassenger(PassengerDto dto) {
        Long ticketId = dto.getTicketId();
        Optional<Ticket> ticket = this.ticketRepository.findTicketsByIdAndExpireDateIsNull(ticketId);
        Passenger passenger = this.passengerMapper.toEntity(dto);
        if (ticket.isPresent()) {
            Passenger savedPassenger = this.passengerRepository.save(passenger);
            savedPassenger.setTicket(ticket.get());
            ticket.get().setBookedAt(LocalDateTime.now());
            return ApiResponse.<PassengerDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.passengerMapper.toDto(savedPassenger))
                    .build();
        }
        return ApiResponse.<PassengerDto>builder()
                .success(false)
                .message("Not found")
                .code(-2)
                .build();

    }

    @Override
    public ApiResponse<PassengerDto> getPassengerById(Long passengerId) {
        Optional<Passenger> passenger = this.passengerRepository.findByIdAndDeletedAtIsNull(passengerId);
        if (passenger.isEmpty()) {
            return ApiResponse.<PassengerDto>builder()
                    .success(false)
                    .message("Passenger Not found")
                    .code(-2)
                    .build();
        }
        return ApiResponse.<PassengerDto>builder()
                .success(true)
                .message("OK")
                .content(this.passengerMapper.toDto(passenger.get()))
                .build();
    }

    @Override
    public ApiResponse<List<PassengerDto>> getAllPassengers() {
        List<Passenger> allPassenger = this.passengerRepository.getAllPassenger();
        System.out.println(allPassenger);
        List<PassengerDto> passengerDtos = new ArrayList<>();
        for (Passenger passenger : allPassenger) {
            passengerDtos.add(this.passengerMapper.toDto(passenger));
        }
        return ApiResponse.<List<PassengerDto>>builder()
                .success(true)
                .message("OK")
                .content(passengerDtos)
                .build();
    }

    @Override
    public ApiResponse<PassengerDto> updatePassengerById(Long passengerId, PassengerDto dto) {
        Optional<Passenger> optionalPassenger = this.passengerRepository.findByIdAndDeletedAtIsNull(passengerId);
        if (optionalPassenger.isEmpty()) {
            return ApiResponse.<PassengerDto>builder()
                    .success(false)
                    .message("Passenger Not found")
                    .code(-2)
                    .build();
        }
        Passenger passenger = optionalPassenger.get();
        Passenger checked = this.passengerMapper.checkAllPassengers(passenger, dto);
        Passenger savedPassenger = this.passengerRepository.save(checked);
        savedPassenger.setUpdatedAt(LocalDateTime.now());
        return ApiResponse.<PassengerDto>builder()
                .success(true)
                .message("OK")
                .content(this.passengerMapper.toDto(savedPassenger))
                .build();
    }

    @Override
    public ApiResponse<PassengerDto> deletePassengerById(Long passengerId) {
        Optional<Passenger> optionalPassenger = this.passengerRepository.findByIdAndDeletedAtIsNull(passengerId);
        if (optionalPassenger.isEmpty()) {
            return ApiResponse.<PassengerDto>builder()
                    .success(false)
                    .message("Passenger Not found")
                    .code(-2)
                    .build();
        }
        Passenger passenger = optionalPassenger.get();
        passenger.setDeletedAt(LocalDateTime.now());
        return ApiResponse.<PassengerDto>builder()
                .success(true)
                .message("OK")
                .content(this.passengerMapper.toDto(passenger))
                .build();
    }
}
