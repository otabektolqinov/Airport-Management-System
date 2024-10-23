package com.airport.Airport.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Flight flight;
    private String seatNumber;
    private Double price;
    private LocalDateTime bookingDate;
    @OneToOne(
            fetch = FetchType.EAGER
    )
    private Passenger passenger;
    private LocalDateTime expireDate;
    private LocalDateTime bookedAt;




}
