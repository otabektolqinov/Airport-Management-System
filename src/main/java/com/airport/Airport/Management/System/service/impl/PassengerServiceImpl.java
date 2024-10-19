package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.ErrorDto;
import com.airport.Airport.Management.System.dto.PassengerDto;
import com.airport.Airport.Management.System.model.Passenger;
import com.airport.Airport.Management.System.repository.PassengerRepository;
import com.airport.Airport.Management.System.service.PassengerService;
import com.airport.Airport.Management.System.service.mapper.PassengerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerMapper passengerMapper;
    private final PassengerRepository passengerRepository;

    @Override
    public ApiResponse<PassengerDto> createPassenger(PassengerDto dto) {

        Passenger passenger = this.passengerMapper.toEntity(dto);
        Passenger savedPassenger = this.passengerRepository.save(passenger);
        return ApiResponse.<PassengerDto>builder()
                .success(true)
                .message("OK")
                .content(this.passengerMapper.toDto(savedPassenger))
                .build();
    }

    @Override
    public ApiResponse<PassengerDto> getPassengerById(Long passengerId) {
        Optional<Passenger> passenger = this.passengerRepository.findById(passengerId);
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
        Optional<Passenger> optionalPassenger = this.passengerRepository.findById(passengerId);
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

        return ApiResponse.<PassengerDto>builder()
                .success(true)
                .message("OK")
                .content(this.passengerMapper.toDto(savedPassenger))
                .build();
    }

    @Override
    public ApiResponse<PassengerDto> deletePassengerById(Long passengerId) {
        Optional<Passenger> optionalPassenger = this.passengerRepository.findById(passengerId);
        if (optionalPassenger.isEmpty()) {
            return ApiResponse.<PassengerDto>builder()
                    .success(false)
                    .message("Passenger Not found")
                    .code(-2)
                    .build();
        }
        Passenger passenger = optionalPassenger.get();
        this.passengerRepository.delete(passenger);
        return ApiResponse.<PassengerDto>builder()
                .success(true)
                .message("OK")
                .content(this.passengerMapper.toDto(passenger))
                .build();
    }
}
