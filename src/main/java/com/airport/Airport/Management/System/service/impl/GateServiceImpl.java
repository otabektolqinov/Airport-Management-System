package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.GateDto;
import com.airport.Airport.Management.System.model.Gate;
import com.airport.Airport.Management.System.repository.GateRepository;
import com.airport.Airport.Management.System.service.GateService;
import com.airport.Airport.Management.System.service.mapper.GateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GateServiceImpl implements GateService {

    private final GateRepository gateRepository;
    private final GateMapper gateMapper;


    @Override
    public ApiResponse<GateDto> createGate(GateDto dto) {

        Gate gate = gateMapper.toEntity(dto);
        Gate saved = gateRepository.save(gate);

        return ApiResponse.<GateDto>builder()
                .content(gateMapper.toDto(saved))
                .success(true)
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<GateDto> getGateById(Long id) {

        Optional<Gate> optional = gateRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<GateDto>builder()
                    .code(-3)
                    .message(String.format("Gate with %d is not found", id))
                    .success(false)
                    .build();
        }
        return ApiResponse.<GateDto>builder()
                .success(true)
                .message("ok")
                .content(gateMapper.toDto(optional.get()))
                .build();
    }

    @Override
    public ApiResponse<GateDto> updateGateById(GateDto dto, Long id) {
        Optional<Gate> optional = gateRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<GateDto>builder()
                    .code(-3)
                    .message(String.format("Gate with %d is not found", id))
                    .success(false)
                    .build();
        }
        Gate gate = gateMapper.updateAllFields(optional.get(), dto);
        Gate saved = gateRepository.save(gate);

        return ApiResponse.<GateDto>builder()
                .content(gateMapper.toDto(saved))
                .message("successfully updated")
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<GateDto> deleteGateById(Long id) {
        Optional<Gate> optional = gateRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<GateDto>builder()
                    .code(-3)
                    .message(String.format("Gate with %d is not found", id))
                    .success(false)
                    .build();
        }
        gateRepository.delete(optional.get());

        return ApiResponse.<GateDto>builder()
                .content(gateMapper.toDto(optional.get()))
                .message("successfully deleted")
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<List<GateDto>> getAllGates() {
        List<Gate> allGates = gateRepository.getAllGates();
        if (allGates.isEmpty()){
            return ApiResponse.<List<GateDto>>builder()
                    .success(false)
                    .code(-3)
                    .message("Gate list is empty")
                    .build();
        }

        return ApiResponse.<List<GateDto>>builder()
                .message("ok")
                .content(gateMapper.gateDtoList(allGates))
                .success(true)
                .build();
    }
}
