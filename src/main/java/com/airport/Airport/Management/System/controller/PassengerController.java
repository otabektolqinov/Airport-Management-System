package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.PassengerDto;
import com.airport.Airport.Management.System.model.Passenger;
import com.airport.Airport.Management.System.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping
    public ApiResponse<PassengerDto> createPassenger(@RequestBody PassengerDto dto) {
        return this.passengerService.createPassenger(dto);
    }

    @GetMapping
    public ApiResponse<PassengerDto> getPassengerById(@RequestParam("id") Long passengerId) {
        return this.passengerService.getPassengerById(passengerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-all")
    public ApiResponse<List<PassengerDto>> getAllPassengers() {
        return this.passengerService.getAllPassengers();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ApiResponse<PassengerDto> updatePassengerById(@RequestParam("id") Long passengerId, @RequestBody PassengerDto dto) {
        return this.passengerService.updatePassengerById(passengerId, dto);
    }

    @DeleteMapping
    public ApiResponse<PassengerDto> deletePassengerById(@RequestParam("id") Long passengerId) {
        return this.passengerService.deletePassengerById(passengerId);
    }
}
