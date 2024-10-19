package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.AircraftDto;
import com.airport.Airport.Management.System.dto.AirlineDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "airline")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;

    @PostMapping
    public ApiResponse<AirlineDto> createAirline(@RequestBody AirlineDto dto){
        return this.airlineService.createAirline(dto);
    }

    @GetMapping
    public ApiResponse<AirlineDto> getAirlineById(@RequestParam(value = "id") Long id){
        return this.airlineService.getAirlineById(id);
    }

    @PutMapping
    public ApiResponse<AirlineDto> updateAirlineById(@RequestBody AirlineDto dto,
                                                     @RequestParam(value = "id") Long id){
        return this.airlineService.updateAirlineById(dto, id);
    }

    @DeleteMapping
    public ApiResponse<AirlineDto> deleteAirlineById(@RequestParam(value = "id") Long id){
        return this.airlineService.deleteAirlineById(id);
    }

    @GetMapping(value = "/get-all")
    public ApiResponse<List<AirlineDto>> getAllAirlines(){
        return this.airlineService.getAllAirlines();
    }

}
