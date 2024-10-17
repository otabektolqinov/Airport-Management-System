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
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "terminal",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE
    )
    private List<Gate> gates;
}
