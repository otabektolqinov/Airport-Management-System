package com.airport.Airport.Management.System.dto;

import lombok.*;

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

}
