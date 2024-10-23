package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.AirportDto;
import com.airport.Airport.Management.System.model.Airport;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AirportMapper {

    @Autowired
    protected FlightMapper flightMapper;
    @Autowired
    protected TerminalMapper terminalMapper;


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "arrivingFlights", ignore = true)
    @Mapping(target = "leavingFlights", ignore = true)
    @Mapping(target = "terminals", ignore = true)
    public abstract Airport toEntity(AirportDto dto);

    @Named(value = "toDto")
    @Mapping(target = "arrivingFlights", ignore = true)
    @Mapping(target = "leavingFlights", ignore = true)
    @Mapping(target = "terminals", ignore = true)
    public abstract AirportDto toDto(Airport airport);

    @Mapping(target = "arrivingFlights", expression = "java(this.flightMapper.dtoList(airport.getArrivingFlights()))")
    @Mapping(target = "leavingFlights", expression = "java(this.flightMapper.dtoList(airport.getLeavingFlights()))")
    @Mapping(target = "terminals", expression = "java(this.terminalMapper.terminalDtoList(airport.getTerminals()))")
    public abstract AirportDto toDtoWithAllEntity(Airport airport);

    @Mapping(target = "arrivingFlights", ignore = true)
    @Mapping(target = "leavingFlights", ignore = true)
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
