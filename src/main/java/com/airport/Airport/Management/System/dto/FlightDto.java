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
    private Long departureAirportId;
    private Long arrivalAirportId;
    private Long aircraftId;
    private List<PassengerDto> passengers;
    private Long gateId;
    private List<StaffDto> staffList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
