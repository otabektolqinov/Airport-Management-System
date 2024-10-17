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
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int capacity;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private Airline airline;

}
