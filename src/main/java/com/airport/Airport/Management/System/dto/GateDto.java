package com.airport.Airport.Management.System.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GateDto {

    private Long id;
    private String number;
    private Long terminalId;
    private List<FlightDto> assignedFlights;

}
