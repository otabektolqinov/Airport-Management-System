package com.airport.Airport.Management.System.service;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.StaffDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {

    ApiResponse<StaffDto> createStaff(StaffDto dto);
    ApiResponse<StaffDto> getStaffById(Long id);
    ApiResponse<StaffDto> updateStaffById(StaffDto dto, Long id);
    ApiResponse<StaffDto> deleteStaffById(Long id);
    ApiResponse<List<StaffDto>> getAllStaffs();

}
