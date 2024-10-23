package com.airport.Airport.Management.System.service.mapper;

import com.airport.Airport.Management.System.dto.StaffDto;
import com.airport.Airport.Management.System.model.Staff;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {

    @Autowired
    protected FlightMapper flightMapper;

    @Named(value = "toDto")
    @Mapping(target = "assignedFlights", ignore = true)
    public abstract StaffDto toDto(Staff staff);

    @Mapping(target = "assignedFlights", expression = "java(this.flightMapper.dtoList(staff.getAssignedFlights()))")
    public abstract StaffDto toDtoWithAllEntity(Staff staff);

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
