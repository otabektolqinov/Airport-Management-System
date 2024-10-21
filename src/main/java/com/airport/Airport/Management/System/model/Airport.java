package com.airport.Airport.Management.System.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String location;
    @OneToMany(
            mappedBy = "arrivalAirport",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Flight> arrivingFlights;
    @OneToMany(
            mappedBy = "departureAirport",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Flight> leavingFlights;
    @OneToMany(
            mappedBy = "airport",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Terminal> terminals;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
