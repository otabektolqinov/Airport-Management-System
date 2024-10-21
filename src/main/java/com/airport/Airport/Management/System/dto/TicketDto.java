package com.airport.Airport.Management.System.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private Long flightId;
    private String seatNumber;
    private Double price;
    private LocalDateTime bookingDate;
}
