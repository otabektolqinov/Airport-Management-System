package com.airport.Airport.Management.System.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Passenger { //Ticket, Passenger, Flight, CRUD for Bobur
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false, updatable = false)
    private String passportNumber;
    private String contactDetails;
    @OneToOne(mappedBy = "passenger",
            cascade = CascadeType.ALL
    )
    private Ticket ticket;
    @CreationTimestamp
    @Column(
            updatable = false,
            columnDefinition = "timestamp default current_timestamp"
    )
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(
            columnDefinition = "timestamp default current_timestamp"
    )
    private LocalDateTime updatedAt;
    @Column(
            updatable = false
    )
    private LocalDateTime deletedAt;


}
