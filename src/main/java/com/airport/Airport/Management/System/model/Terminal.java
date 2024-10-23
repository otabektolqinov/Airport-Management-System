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
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "terminal",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Gate> gates;
    @ManyToOne(fetch = FetchType.EAGER)
    private Airport airport;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
