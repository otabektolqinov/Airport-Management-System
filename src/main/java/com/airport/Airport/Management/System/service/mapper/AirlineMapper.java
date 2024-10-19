package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.AirlineDto;
import com.airport.Airport.Management.System.model.Airline;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AirlineMapper {


    @Named(value = "toDto")
    @Mapping(target = "fleet", ignore = true)
    public abstract AirlineDto toDto(Airline airline);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fleet", ignore = true)
    public abstract Airline toEntity(AirlineDto dto);

    @BeanMapping(
            resultType = Airline.class,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public abstract Airline updateAllFields(@MappingTarget Airline airline, AirlineDto dto);

    @IterableMapping(
            qualifiedByName = "toDto"
    )
    public abstract List<AirlineDto> airlineList(List<Airline> airlines);

}
