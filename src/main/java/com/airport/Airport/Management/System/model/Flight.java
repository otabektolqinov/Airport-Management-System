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
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Airport departureAirport;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Airport arrivalAirport;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Aircraft aircraft;

    @ManyToMany(
            fetch = FetchType.LAZY
    )
    private List<Passenger> passengers;
    @ManyToOne(fetch = FetchType.LAZY)
    private Gate gate;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Staff> staffList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
