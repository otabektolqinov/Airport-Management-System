package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.AirportDto;
import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "airport")
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public ApiResponse<AirportDto> createAirport(@RequestBody AirportDto dto){
        return this.airportService.createAirport(dto);
    }

    @GetMapping
    public ApiResponse<AirportDto> getAirportById(@RequestParam(value = "id") Long id){
        return this.airportService.getAirportById(id);
    }

    @PutMapping
    public ApiResponse<AirportDto> updateAirportById(@RequestBody AirportDto dto, @RequestParam(value = "id") Long id){
        return this.airportService.updateAirportById(dto, id);
    }

    @DeleteMapping
    public ApiResponse<AirportDto> deleteAirportById(@RequestParam(value = "id") Long id){
        return this.airportService.deleteAirportById(id);
    }

    @GetMapping(value = "/get-all")
    public ApiResponse<List<AirportDto>> getAllAirports(){
        return this.airportService.getAllAirports();
    }





}
