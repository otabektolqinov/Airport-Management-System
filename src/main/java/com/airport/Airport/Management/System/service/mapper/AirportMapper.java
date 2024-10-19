package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.AirportDto;
import com.airport.Airport.Management.System.model.Airport;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AirportMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "flights", ignore = true)
    @Mapping(target = "terminals", ignore = true)
    public abstract Airport toEntity(AirportDto dto);

    @Named(value = "toDto")
    @Mapping(target = "flights", ignore = true)
    @Mapping(target = "terminals", ignore = true)
    public abstract AirportDto toDto(Airport airport);

    @Mapping(target = "flights", ignore = true)
    @Mapping(target = "terminals", ignore = true)
    @BeanMapping(
            resultType = Airport.class,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public abstract Airport updateAllFields(@MappingTarget Airport airport, AirportDto dto);

    @IterableMapping(
            qualifiedByName = "toDto"
    )
    public abstract List<AirportDto> getAllAirports(List<Airport> airports);

}
