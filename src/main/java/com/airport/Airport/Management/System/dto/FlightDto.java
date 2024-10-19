package com.airport.Airport.Management.System.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
