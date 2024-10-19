package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.FlightDto;
import com.airport.Airport.Management.System.model.Flight;
import com.airport.Airport.Management.System.repository.FlightRepository;
import com.airport.Airport.Management.System.service.FlightService;
import com.airport.Airport.Management.System.service.mapper.FlightMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    @Override
    public ApiResponse<FlightDto> createFlight(FlightDto dto) {
        Flight entity = this.flightMapper.toEntity(dto);
        Flight saved = this.flightRepository.save(entity);
        return ApiResponse.<FlightDto>builder()
                .success(true)
                .message("Ok")
                .content(this.flightMapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<FlightDto> getFlightById(Long id) {
        Optional<Flight> flight = this.flightRepository.findById(id);
        if (flight.isPresent()) {
            return ApiResponse.<FlightDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.flightMapper.toDto(flight.get()))
                    .build();
        }
        return ApiResponse.<FlightDto>builder()
                .success(false)
                .message("Not found")
                .code(-2)
                .build();
    }

    @Override
    public ApiResponse<FlightDto> deleteFlightById(Long id) {
        Optional<Flight> flight = this.flightRepository.findById(id);
        if (flight.isPresent()) {
            this.flightRepository.delete(flight.get());
            return ApiResponse.<FlightDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.flightMapper.toDto(flight.get()))
                    .build();
        }
        return ApiResponse.<FlightDto>builder()
                .success(false)
                .message("Not found")
                .code(-2)
                .build();
    }

    @Override
    public ApiResponse<FlightDto> updateFlight(Long id, FlightDto dto) {
        Optional<Flight> flight = this.flightRepository.findById(id);
        if (flight.isPresent()) {
            Flight flight1 = this.flightMapper.updateFlightAllFiled(flight.get(), dto);
            Flight saved = this.flightRepository.save(flight1);
            return ApiResponse.<FlightDto>builder()
                    .success(true)
                    .message("Ok")
                    .content(this.flightMapper.toDto(saved))
                    .build();

        }
        return ApiResponse.<FlightDto>builder()
                .success(false)
                .message("Flight not found")
                .code(-2)
                .build();
    }

    @Override
    public ApiResponse<List<FlightDto>> getAllFlights() {
        List<Flight> flights = this.flightRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();
        for (Flight flight : flights) {
            flightDtoList.add(this.flightMapper.toDto(flight));
        }
        if (!flightDtoList.isEmpty()) {
            return ApiResponse.<List<FlightDto>>builder()
                    .success(true)
                    .message("Ok")
                    .content(flightDtoList)
                    .build();
        }
        return ApiResponse.<List<FlightDto>>builder()
                .success(false)
                .message("FlightList is empty")
                .code(-2)
                .build();

    }
}
