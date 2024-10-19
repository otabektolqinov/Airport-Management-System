package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.GateDto;
import com.airport.Airport.Management.System.service.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "gate")
@RequiredArgsConstructor
public class GateController {

    private final GateService gateService;

    @PostMapping
    public ApiResponse<GateDto> createGate(@RequestBody GateDto dto){
        return this.gateService.createGate(dto);
    }

    @GetMapping
    public ApiResponse<GateDto> getGateById(@RequestParam(value = "id") Long id){
        return this.gateService.getGateById(id);
    }

    @PutMapping
    public ApiResponse<GateDto> updateGetById(GateDto dto, Long id){
        return this.gateService.updateGateById(dto, id);
    }

    @DeleteMapping
    public ApiResponse<GateDto> deleteGateById(Long id){
        return gateService.deleteGateById(id);
    }

    @GetMapping("/get-all")
    public ApiResponse<List<GateDto>> getAllGates(){
        return this.gateService.getAllGates();

    }
}

