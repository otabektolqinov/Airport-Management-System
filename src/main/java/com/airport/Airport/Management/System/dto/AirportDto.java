package com.airport.Airport.Management.System.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "name cannot be null or blank")
    @NotNull(message = "name cannot be null")
    private String name;
    @NotBlank(message = "code cannot be null or blank")
    @NotNull(message = "code cannot be null or blank")
    private String code;
    @NotBlank(message = "location cannot be null or blank")
    @NotNull(message = "location cannot be null or blank")
    private String location;
    private List<FlightDto> leavingFlights;
    private List<FlightDto> arrivingFlights;
    private List<TerminalDto> terminals;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
