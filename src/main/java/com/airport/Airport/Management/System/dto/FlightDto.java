package com.airport.Airport.Management.System.dto;

import com.airport.Airport.Management.System.model.Aircraft;
import com.airport.Airport.Management.System.model.Airport;
import com.airport.Airport.Management.System.model.Passenger;
import java.time.LocalDateTime;
import java.util.List;

public class FlightDto {
    private Long id;
    private String flightNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    private Integer aircraftId;
    private List<PassengerDto> passengers;
}
