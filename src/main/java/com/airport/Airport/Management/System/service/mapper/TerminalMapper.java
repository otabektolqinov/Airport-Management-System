package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.TerminalDto;
import com.airport.Airport.Management.System.model.Terminal;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TerminalMapper {

    @Autowired
    protected GateMapper gateMapper;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gates", ignore = true)
    public abstract Terminal toEntity(TerminalDto dto);

    @Named(value = "toDto")
    @Mapping(target = "gates", ignore = true)
    public abstract TerminalDto toDto(Terminal terminal);

    @Mapping(target = "airportId", expression = "java(terminal.getAirport().getId())")
    @Mapping(target = "gates", expression = "java(this.gateMapper.gateDtoList(terminal.getGates()))")
    public abstract TerminalDto toDtoWithAllEntity(Terminal terminal);

    @BeanMapping(
            resultType = Terminal.class,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public abstract Terminal updateAllFields(@MappingTarget Terminal terminal, TerminalDto dto);

    @IterableMapping(
            qualifiedByName = "toDto"
    )
    public abstract List<TerminalDto> terminalDtoList(List<Terminal> terminals);
}
