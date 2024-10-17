package com.airport.Airport.Management.System.dto;

import com.airport.Airport.Management.System.model.Aircraft;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineDto {

    private Long id;
    private String name;
    private String code;
    private List<AircraftDto> fleet;
}
