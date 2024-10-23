package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.AircraftDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.model.Aircraft;
import com.airport.Airport.Management.System.model.Airline;
import com.airport.Airport.Management.System.model.Airport;
import com.airport.Airport.Management.System.repository.AircraftRepository;
import com.airport.Airport.Management.System.repository.AirlineRepository;
import com.airport.Airport.Management.System.service.AircraftService;
import com.airport.Airport.Management.System.service.mapper.AircraftMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;
    private final AircraftMapper aircraftMapper;

    @Override
    public ApiResponse<AircraftDto> createAircraftDto(AircraftDto dto) {
        Aircraft aircraft = aircraftMapper.toEntity(dto);
        Optional<Airline> optionalAirline = airlineRepository.findById(dto.getAirlineId());
        if (optionalAirline.isEmpty()){
            return ApiResponse.<AircraftDto>builder()
                    .code(-3)
                    .success(false)
                    .message(String.format("Airline with %d id is not found", dto.getAirlineId()))
                    .build();
        }
        aircraft.setAirline(optionalAirline.get());
        Aircraft saved = aircraftRepository.save(aircraft);
        return ApiResponse.<AircraftDto>builder()
                .success(true)
                .message("ok")
                .content(aircraftMapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<AircraftDto> getAircraftById(Long id) {
        Optional<Aircraft> optional = aircraftRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<AircraftDto>builder()
                    .code(-3)
                    .success(false)
                    .message(String.format("Aircraft with %d id is not found", id))
                    .build();
        }

        return ApiResponse.<AircraftDto>builder()
                .success(true)
                .message("ok")
                .content(aircraftMapper.toDtoWithAllEntity(optional.get()))
                .build();
    }

    @Override
    public ApiResponse<AircraftDto> updateAircraftById(AircraftDto dto, Long id) {

        Optional<Aircraft> optional = aircraftRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<AircraftDto>builder()
                    .code(-3)
                    .success(false)
                    .message(String.format("Aircraft with %d id is not found", id))
                    .build();
        }
        Aircraft aircraft = aircraftMapper.updateAllFields(optional.get(), dto);
        Aircraft saved = aircraftRepository.save(aircraft);
        return ApiResponse.<AircraftDto>builder()
                .content(aircraftMapper.toDto(saved))
                .message("Successfully updated")
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<AircraftDto> deleteAircraftById(Long id) {
        Optional<Aircraft> optional = aircraftRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<AircraftDto>builder()
                    .code(-3)
                    .success(false)
                    .message(String.format("Aircraft with %d id is not found", id))
                    .build();
        }
        aircraftRepository.delete(optional.get());
        return ApiResponse.<AircraftDto>builder()
                .content(aircraftMapper.toDto(optional.get()))
                .success(true)
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<List<AircraftDto>> getAllAircrafts() {
        List<Aircraft> aircrafts = aircraftRepository.getAll();
        if (aircrafts.isEmpty()){
            return ApiResponse.<List<AircraftDto>>builder()
                    .message("Aircraft list is empty")
                    .code(-3)
                    .success(false)
                    .build();
        }
        return ApiResponse.<List<AircraftDto>>builder()
                .message("ok")
                .success(true)
                .content(aircraftMapper.getAllAircrafts(aircrafts))
                .build();
    }
}
