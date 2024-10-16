package com.airport.Airport.Management.System.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gate {

    private Long id;
    private String number;
    private Terminal terminal;
    private List<Flight> assignedFlights;

}
