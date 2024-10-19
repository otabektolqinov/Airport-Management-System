package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.GateDto;
import com.airport.Airport.Management.System.model.Gate;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GateMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "terminal", ignore = true)
    @Mapping(target = "assignedFlights", ignore = true)
    public abstract Gate toEntity(GateDto dto);

    @Named(value = "toDto")
    @Mapping(target = "terminalId", ignore = true)
    @Mapping(target = "assignedFlights", ignore = true)
    public abstract GateDto toDto(Gate gate);

    @BeanMapping(
            resultType = Gate.class,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public abstract Gate updateAllFields(@MappingTarget Gate gate, GateDto dto);

    @IterableMapping(qualifiedByName = "toDto")
    public abstract List<GateDto> gateDtoList(List<Gate> gates);

}
