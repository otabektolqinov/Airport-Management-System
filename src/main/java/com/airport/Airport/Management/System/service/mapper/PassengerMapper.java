package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.PassengerDto;
import com.airport.Airport.Management.System.model.Passenger;
import com.airport.Airport.Management.System.model.Ticket;
import com.airport.Airport.Management.System.repository.PassengerRepository;
import com.airport.Airport.Management.System.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(componentModel = "spring")
//@AllArgsConstructor
public abstract class PassengerMapper {


    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "ticketId", ignore = true)
    public abstract Passenger toEntity(PassengerDto dto);

    @Mapping(target = "ticketId", ignore = true)
    public abstract PassengerDto toDto(Passenger entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Passenger checkAllPassengers(@MappingTarget Passenger passenger, PassengerDto dto);
}
