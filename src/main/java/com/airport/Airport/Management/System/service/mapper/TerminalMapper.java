package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.TerminalDto;
import com.airport.Airport.Management.System.model.Terminal;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TerminalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gates", ignore = true)
    public abstract Terminal toEntity(TerminalDto dto);

    @Named(value = "toDto")
    @Mapping(target = "gates", ignore = true)
    public abstract TerminalDto toDto(Terminal terminal);

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
