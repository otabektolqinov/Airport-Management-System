package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.StaffDto;
import com.airport.Airport.Management.System.model.Staff;
import com.airport.Airport.Management.System.repository.StaffRepository;
import com.airport.Airport.Management.System.service.StaffService;
import com.airport.Airport.Management.System.service.mapper.StaffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffMapper mapper;
    private final StaffRepository repository;


    @Override
    public ApiResponse<StaffDto> createStaff(StaffDto dto) {
        Staff staff = mapper.toEntity(dto);
        Staff saved = repository.save(staff);

        return ApiResponse.<StaffDto>builder()
                .success(true)
                .message("ok")
                .content(mapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<StaffDto> getStaffById(Long id) {
        Optional<Staff> optional = repository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<StaffDto>builder()
                    .code(-3)
                    .message(String.format("Staff with %d id is not found", id))
                    .success(false)
                    .build();
        }
        return ApiResponse.<StaffDto>builder()
                .success(true)
                .content(mapper.toDtoWithAllEntity(optional.get()))
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<StaffDto> updateStaffById(StaffDto dto, Long id) {
        Optional<Staff> optional = repository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<StaffDto>builder()
                    .code(-3)
                    .message(String.format("Staff with %d id is not found", id))
                    .success(false)
                    .build();
        }
        Staff staff = mapper.updateAllFields(optional.get(), dto);
        Staff saved = repository.save(staff);

        return ApiResponse.<StaffDto>builder()
                .message("successfully updated")
                .content(mapper.toDto(saved))
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<StaffDto> deleteStaffById(Long id) {

        Optional<Staff> optional = repository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<StaffDto>builder()
                    .code(-3)
                    .message(String.format("Staff with %d id is not found", id))
                    .success(false)
                    .build();
        }
        repository.delete(optional.get());
        return ApiResponse.<StaffDto>builder()
                .success(true)
                .content(mapper.toDto(optional.get()))
                .message("successfully deleted")
                .build();
    }

    @Override
    public ApiResponse<List<StaffDto>> getAllStaffs() {
        List<Staff> staffList = repository.getAll();
        if (staffList.isEmpty()){
            return ApiResponse.<List<StaffDto>>builder()
                    .message("Staff list empty")
                    .code(-3)
                    .success(false)
                    .build();
        }

        return ApiResponse.<List<StaffDto>>builder()
                .success(true)
                .message("ok")
                .content(mapper.getAllStaff(staffList))
                .build();
    }
}
