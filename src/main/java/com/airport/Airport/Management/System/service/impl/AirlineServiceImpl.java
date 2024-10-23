package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.AirlineDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.model.Airline;
import com.airport.Airport.Management.System.repository.AirlineRepository;
import com.airport.Airport.Management.System.service.AirlineService;
import com.airport.Airport.Management.System.service.mapper.AirlineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper;

    @Override
    public ApiResponse<AirlineDto> createAirline(AirlineDto dto) {
        Airline airline = airlineMapper.toEntity(dto);
        Airline saved = airlineRepository.save(airline);

        return ApiResponse.<AirlineDto>builder()
                .success(true)
                .content(airlineMapper.toDto(saved))
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<AirlineDto> getAirlineById(Long id) {
        Optional<Airline> optional = airlineRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<AirlineDto>builder()
                    .success(false)
                    .message(String.format("Airline with %d id is not found", id))
                    .code(-3)
                    .build();
        }
        return ApiResponse.<AirlineDto>builder()
                .content(airlineMapper.toDtoWithAllEntity(optional.get()))
                .message("ok")
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<AirlineDto> updateAirlineById(AirlineDto dto, Long id) {

        Optional<Airline> optional = airlineRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<AirlineDto>builder()
                    .success(false)
                    .message(String.format("Airline with %d id is not found", id))
                    .code(-3)
                    .build();
        }
        Airline airline = airlineMapper.updateAllFields(optional.get(), dto);
        Airline saved = airlineRepository.save(airline);

        return ApiResponse.<AirlineDto>builder()
                .success(true)
                .message("successfully updated")
                .content(airlineMapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<AirlineDto> deleteAirlineById(Long id) {
        Optional<Airline> optional = airlineRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<AirlineDto>builder()
                    .success(false)
                    .message(String.format("Airline with %d id is not found", id))
                    .code(-3)
                    .build();
        }
        airlineRepository.delete(optional.get());
        return ApiResponse.<AirlineDto>builder()
                .content(airlineMapper.toDto(optional.get()))
                .success(true)
                .message("successfully deleted")
                .build();
    }

    @Override
    public ApiResponse<List<AirlineDto>> getAllAirlines() {

        List<Airline> airlines = airlineRepository.getAll();
        if (airlines.isEmpty()){
            return ApiResponse.<List<AirlineDto>>builder()
                    .message("Airline list is empty")
                    .success(false)
                    .code(-3)
                    .build();
        }
        return ApiResponse.<List<AirlineDto>>builder()
                .content(airlineMapper.airlineList(airlines))
                .message("ok")
                .success(true)
                .build();
    }
}
