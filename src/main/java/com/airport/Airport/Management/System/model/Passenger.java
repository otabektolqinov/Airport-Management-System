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
public class Passenger { //Ticket, Passenger, Flight, CRUD for Bobur
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false, updatable = false)
    private String passportNumber;
    private String contactDetails;
   @OneToOne(
           cascade = CascadeType.ALL,
           fetch = FetchType.LAZY
   )
    private Ticket ticket;


}
