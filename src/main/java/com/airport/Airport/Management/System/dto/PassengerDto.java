package com.airport.Airport.Management.System.dto;


import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
