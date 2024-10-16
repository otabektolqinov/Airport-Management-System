package com.airport.Airport.Management.System.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {

    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String contractDetails;
    private Ticket ticket;
}
