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
public class AircraftDto {

    private Long id;
    @NotBlank(message = "model cannot be blank")
    @NotNull(message = "model cannot be null")
    private String model;
    private int capacity;
    @NotNull(message = "airlineId cannot be null")
    private Long airlineId;
    private List<FlightDto> flights;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
