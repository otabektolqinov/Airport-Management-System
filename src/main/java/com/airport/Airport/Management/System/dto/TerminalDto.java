package com.airport.Airport.Management.System.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TerminalDto {

    private Long id;
    private String name;
    private Long airportId;
    private List<GateDto> gates;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
