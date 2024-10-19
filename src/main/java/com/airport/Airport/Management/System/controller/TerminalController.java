package com.airport.Airport.Management.System.controller;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TerminalDto;
import com.airport.Airport.Management.System.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "terminal")
@RequiredArgsConstructor
public class TerminalController {

    private final TerminalService terminalService;

    @PostMapping
    public ApiResponse<TerminalDto> createTerminal(@RequestBody TerminalDto dto){
        return terminalService.createTerminal(dto);
    }

    @GetMapping
    public ApiResponse<TerminalDto> getTerminalById(@RequestParam(value = "id") Long id){
        return terminalService.getTerminalById(id);
    }

    @PutMapping
    public ApiResponse<TerminalDto> updateTerminalById(@RequestBody TerminalDto dto,
                                                       @RequestParam(value = "id") Long id){
        return terminalService.updateTerminalById(dto, id);
    }

    @DeleteMapping
    public ApiResponse<TerminalDto> deleteTerminalById(@RequestParam(value = "id") Long id){
        return terminalService.deleteTerminalById(id);
    }

    @GetMapping("get-all")
    public ApiResponse<List<TerminalDto>> getAllTerminals(){
        return terminalService.getAllTerminals();
    }

}

