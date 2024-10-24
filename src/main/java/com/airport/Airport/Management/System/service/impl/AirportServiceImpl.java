package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.AirportDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.exception.ContentNotFound;
import com.airport.Airport.Management.System.exception.DatabaseException;
import com.airport.Airport.Management.System.model.Airport;
import com.airport.Airport.Management.System.repository.AirportRepository;
import com.airport.Airport.Management.System.service.AirportService;
import com.airport.Airport.Management.System.service.mapper.AirportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;


    @Override
    public ApiResponse<AirportDto> createAirport(AirportDto dto) {
        try {
            Airport airport = airportMapper.toEntity(dto);
            Airport saved = airportRepository.save(airport);
            return ApiResponse.<AirportDto>builder()
                    .success(true)
                    .message("ok")
                    .content(airportMapper.toDto(saved))
                    .build();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    @Override
    public ApiResponse<AirportDto> getAirportById(Long id) {
        try {
            Optional<Airport> airport = airportRepository.findById(id);
            if (airport.isPresent()){
                return ApiResponse.<AirportDto>builder()
                        .success(true)
                        .message("ok")
                        .content(airportMapper.toDtoWithAllEntity(airport.get()))
                        .build();
            }

            throw new ContentNotFound(String.format("Airport with %d is not found", id));
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public ApiResponse<AirportDto> updateAirportById(AirportDto dto, Long id) {

        try {
            Optional<Airport> optionalAirport = airportRepository.findById(id);
            if (optionalAirport.isEmpty()){
                throw new ContentNotFound(String.format("Airport with %d is not found", id));
            }

            Airport airport = airportMapper.updateAllFields(optionalAirport.get(), dto);
            Airport saved = airportRepository.save(airport);
            return ApiResponse.<AirportDto>builder()
                    .success(true)
                    .message("Successfully updated airport")
                    .content(airportMapper.toDto(saved))
                    .build();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    @Override
    public ApiResponse<AirportDto> deleteAirportById(Long id) {
        try {
            Optional<Airport> optionalAirport = airportRepository.findById(id);
            if (optionalAirport.isEmpty()){
                return ApiResponse.<AirportDto>builder()
                        .success(false)
                        .code(-3)
                        .message(String.format("Airport with %d is not found", id))
                        .build();
            }

            airportRepository.delete(optionalAirport.get());
            return ApiResponse.<AirportDto>builder()
                    .success(true)
                    .message("successfully deleted airport")
                    .build();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public ApiResponse<List<AirportDto>> getAllAirports() {
        try {
            List<Airport> airports = airportRepository.getAll();
            if (airports.isEmpty()){
                return ApiResponse.<List<AirportDto>>builder()
                        .code(-3)
                        .success(false)
                        .message("There is no airports")
                        .build();
            }

            List<AirportDto> allAirports = airportMapper.getAllAirports(airports);
            return ApiResponse.<List<AirportDto>>builder()
                    .content(allAirports)
                    .success(true)
                    .message("ok")
                    .build();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
