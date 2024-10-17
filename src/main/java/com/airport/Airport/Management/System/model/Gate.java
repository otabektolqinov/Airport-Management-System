package com.airport.Airport.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    private Terminal terminal;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Flight> assignedFlights;


}
