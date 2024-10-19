package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.StaffDto;
import com.airport.Airport.Management.System.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping
    public ApiResponse<StaffDto> createStaff(@RequestBody StaffDto dto){
        return staffService.createStaff(dto);
    }

    @GetMapping
    public ApiResponse<StaffDto> getStaffById(Long id){
        return staffService.getStaffById(id);
    }

    @PutMapping
    public ApiResponse<StaffDto> updateStaffById(@RequestBody StaffDto dto,
                                                 @RequestParam(value = "id") Long id){
        return staffService.updateStaffById(dto, id);
    }

    @DeleteMapping
    public ApiResponse<StaffDto> deleteStaffById(@RequestParam(value = "id") Long id){
        return staffService.deleteStaffById(id);
    }

    @GetMapping("/get-all")
    public ApiResponse<List<StaffDto>> getAllStaff(){
        return staffService.getAllStaffs();
    }


}
