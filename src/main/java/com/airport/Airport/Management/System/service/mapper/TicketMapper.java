package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.TicketDto;
import com.airport.Airport.Management.System.model.Ticket;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class TicketMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Ticket toEntity(TicketDto dto);

    public abstract TicketDto toDto(Ticket ticket);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Ticket updateAllTicketFields(@MappingTarget Ticket ticket, TicketDto ticketDto);
}
