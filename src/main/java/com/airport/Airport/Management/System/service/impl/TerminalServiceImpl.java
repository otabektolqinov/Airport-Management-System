package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TerminalDto;
import com.airport.Airport.Management.System.model.Terminal;
import com.airport.Airport.Management.System.repository.AirportRepository;
import com.airport.Airport.Management.System.repository.TerminalRepository;
import com.airport.Airport.Management.System.service.TerminalService;
import com.airport.Airport.Management.System.service.mapper.TerminalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TerminalServiceImpl implements TerminalService {

    private final TerminalRepository terminalRepository;
    private final TerminalMapper terminalMapper;
    private final AirportRepository airportRepository;

    @Override
    public ApiResponse<TerminalDto> createTerminal(TerminalDto dto) {
        Terminal terminal = terminalMapper.toEntity(dto);

        Terminal saved = terminalRepository.save(terminal);


        return ApiResponse.<TerminalDto>builder()
                .success(true)
                .message("ok")
                .content(terminalMapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<TerminalDto> getTerminalById(Long id) {
        Optional<Terminal> optional = terminalRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<TerminalDto>builder()
                    .message(String.format("Terminal with %d id is not found", id))
                    .code(-3)
                    .success(false)
                    .build();
        }
        return ApiResponse.<TerminalDto>builder()
                .success(true)
                .content(terminalMapper.toDto(optional.get()))
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<TerminalDto> updateTerminalById(TerminalDto dto, Long id) {
        Optional<Terminal> optional = terminalRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<TerminalDto>builder()
                    .message(String.format("Terminal with %d id is not found", id))
                    .code(-3)
                    .success(false)
                    .build();
        }
        Terminal terminal = terminalMapper.updateAllFields(optional.get(), dto);
        Terminal saved = terminalRepository.save(terminal);

        return ApiResponse.<TerminalDto>builder()
                .message("successfully updated")
                .content(terminalMapper.toDto(saved))
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<TerminalDto> deleteTerminalById(Long id) {
        Optional<Terminal> optional = terminalRepository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<TerminalDto>builder()
                    .message(String.format("Terminal with %d id is not found", id))
                    .code(-3)
                    .success(false)
                    .build();
        }
        terminalRepository.delete(optional.get());
        return ApiResponse.<TerminalDto>builder()
                .success(true)
                .content(terminalMapper.toDto(optional.get()))
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<List<TerminalDto>> getAllTerminals() {
        List<Terminal> terminals = terminalRepository.getAll();
        if (terminals.isEmpty()){
            return ApiResponse.<List<TerminalDto>>builder()
                    .success(false)
                    .message("Terminal list is empty")
                    .code(-3)
                    .build();
        }
        return ApiResponse.<List<TerminalDto>>builder()
                .content(terminalMapper.terminalDtoList(terminals))
                .message("ok")
                .success(true)
                .build();
    }
}
