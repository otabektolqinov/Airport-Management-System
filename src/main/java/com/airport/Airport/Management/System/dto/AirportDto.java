package com.airport.Airport.Management.System.dto;


import lombok.*;

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
    private List<FlightDto> flights;
    private List<TerminalDto> terminals;

}