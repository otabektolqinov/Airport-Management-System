package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.StaffDto;
import com.airport.Airport.Management.System.model.Staff;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {

    @Named(value = "toDto")
    @Mapping(target = "assignedFlights", ignore = true)
    public abstract StaffDto toDto(Staff staff);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignedFlights", ignore = true)
    public abstract Staff toEntity(StaffDto dto);

    @BeanMapping(
            resultType = Staff.class,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public abstract Staff updateAllFields(@MappingTarget Staff staff, StaffDto dto);

    @IterableMapping(
            qualifiedByName = "toDto"
    )
    public abstract List<StaffDto> getAllStaff(List<Staff> staff);
}
