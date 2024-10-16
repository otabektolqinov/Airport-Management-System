package com.airport.Airport.Management.System.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airport {

    private Long id;
    private String name;
    private String code;
    private String location;
    private List<Flight> flights;

}
