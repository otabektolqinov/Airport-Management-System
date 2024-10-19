package com.airport.Airport.Management.System.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String contactDetails;
    private Long ticketId;
}
