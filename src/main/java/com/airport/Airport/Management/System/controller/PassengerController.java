package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.PassengerDto;
import com.airport.Airport.Management.System.model.Passenger;
import com.airport.Airport.Management.System.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "passengers")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping
    public PassengerDto createPassenger(@RequestBody PassengerDto dto) {
        return this.passengerService.createPassenger(dto);
    }

    @GetMapping
    public PassengerDto getPassengerById(@RequestParam("id") Long passengerId) {
        return this.passengerService.getPassengerById(passengerId);
    }
    @GetMapping(params = "get-all")
    public List<PassengerDto> getAllPassengers() {
        return this.passengerService.getAllPassengers();
    }
}
