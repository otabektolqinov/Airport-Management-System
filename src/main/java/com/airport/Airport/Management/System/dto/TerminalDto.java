package com.airport.Airport.Management.System.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TerminalDto {

    private Long id;
    private String name;
    private List<GateDto> gates;

}
