package com.airport.Airport.Management.System.dto;

import com.airport.Airport.Management.System.model.Flight;

import java.time.LocalDateTime;

public class TicketDto {
    private Long id;
    private Integer flightId;
    private String seatNumber;
    private Double price;
    private LocalDateTime bookingDate;
}
