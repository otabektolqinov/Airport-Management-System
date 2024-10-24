package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.AircraftDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.service.AircraftService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "aircraft")
@RequiredArgsConstructor
@RestController
public class AircraftController {

    private final AircraftService aircraftService;

    @PostMapping
    public ApiResponse<AircraftDto> createAircraft(@RequestBody @Valid AircraftDto dto){
        return this.aircraftService.createAircraftDto(dto);
    }

    @GetMapping
    public ApiResponse<AircraftDto> getAircraftById(@RequestParam(value = "id") Long id){
        return this.aircraftService.getAircraftById(id);
    }

    @PutMapping
    public ApiResponse<AircraftDto> updateAircraftById(@RequestBody AircraftDto dto,
                                                       @RequestParam(value = "id") Long id){

        return this.aircraftService.updateAircraftById(dto, id);
    }

    @DeleteMapping
    public ApiResponse<AircraftDto> deleteAircraftById(@RequestParam(value = "id") Long id){
        return this.aircraftService.deleteAircraftById(id);
    }

    @GetMapping(value = "/get-all")
    public ApiResponse<List<AircraftDto>> getAllAircraft(){
        return this.aircraftService.getAllAircrafts();
    }
}
