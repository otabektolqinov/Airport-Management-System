package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.FlightDto;
import com.airport.Airport.Management.System.model.Flight;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FlightMapper {


    public abstract Flight toEntity(FlightDto dto);

    @Named(value = "toDto")
    public abstract FlightDto toDto(Flight flight);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Flight updateFlightAllFiled(@MappingTarget Flight flight, FlightDto dto);

    @IterableMapping(
            qualifiedByName = "toDto"
    )
    public abstract List<FlightDto> dtoList(List<Flight> flights);
}
