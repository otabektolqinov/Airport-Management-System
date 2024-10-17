package com.airport.Airport.Management.System.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffDto {

    private Long id;
    private String name;
    private String role;
    private List<FlightDto> assignedFlights;

}
