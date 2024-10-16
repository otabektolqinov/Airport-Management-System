package com.airport.Airport.Management.System.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airline {

    private Long id;
    private String name;
    private String code;
    private List<Aircraft> fleet;

}
