package com.airport.Airport.Management.System.dto;


import com.airport.Airport.Management.System.model.Flight;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDto {

    private Long id;
    private String name;
    private String code;
    private String location;
    private List<FlightDto> leavingFlights;
    private List<FlightDto> arrivalFlights;
    private List<TerminalDto> terminals;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
