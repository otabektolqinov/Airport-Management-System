package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.FlightDto;
import com.airport.Airport.Management.System.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "flight")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping
    private ApiResponse<FlightDto> createFlight(@RequestBody FlightDto dto) {
        return this.flightService.createFlight(dto);
    }

    @GetMapping
    public ApiResponse<FlightDto> getFlightById(@RequestParam("id") Long flightId) {
        return this.flightService.getFlightById(flightId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-all")
    public ApiResponse<List<FlightDto>> getAllFlights() {
        return this.flightService.getAllFlights();
    }

    @PutMapping
    private ApiResponse<FlightDto> updateFlightById(@RequestParam("id") Long id, @RequestBody FlightDto dto) {
        return this.flightService.updateFlight(id, dto);
    }

    @DeleteMapping
    private ApiResponse<FlightDto> deleteFlightById(@RequestParam("id") Long id) {
        return this.flightService.deleteFlightById(id);
    }
}
