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
public class AirlineDto {

    private Long id;
    @NotBlank(message = "name cannot be blank")
    @NotNull(message = "name cannot be null")
    private String name;
    @NotBlank(message = "code cannot be blank")
    @NotNull(message = "code cannot be null")
    private String code;
    private List<AircraftDto> fleet;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
