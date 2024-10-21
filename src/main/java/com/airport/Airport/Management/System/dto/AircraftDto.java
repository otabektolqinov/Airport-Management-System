package com.airport.Airport.Management.System.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftDto {

    private Long id;
    private String model;
    private int capacity;
    private Long airlineId;
    private List<FlightDto> flights;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
