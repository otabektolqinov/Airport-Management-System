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
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @OneToMany(
            mappedBy = "airline",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Aircraft> fleet;

}
