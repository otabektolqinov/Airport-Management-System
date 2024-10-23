package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.AircraftDto;
import com.airport.Airport.Management.System.model.Aircraft;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AircraftMapper {

    @Mapping(target = "airlineId", ignore = true)
    public abstract AircraftDto toDto(Aircraft aircraft);

    @Named(value = "toDto")
    public abstract AircraftDto toDtoWithAllEntity(Aircraft aircraft);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "airline", ignore = true)
    public abstract Aircraft toEntity(AircraftDto dto);

    @BeanMapping(
            resultType = Aircraft.class,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public abstract Aircraft updateAllFields(@MappingTarget Aircraft aircraft, AircraftDto dto);

    @IterableMapping(
            qualifiedByName = "toDto"
    )
    public abstract List<AircraftDto> getAllAircrafts(List<Aircraft> aircrafts);
}
