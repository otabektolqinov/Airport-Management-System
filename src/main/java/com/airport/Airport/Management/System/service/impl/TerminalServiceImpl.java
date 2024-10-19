package com.airport.Airport.Management.System.service.impl;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.TerminalDto;
import com.airport.Airport.Management.System.model.Terminal;
import com.airport.Airport.Management.System.repository.TerminalRepository;
import com.airport.Airport.Management.System.service.TerminalService;
import com.airport.Airport.Management.System.service.mapper.TerminalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TerminalServiceImpl implements TerminalService {

    private final TerminalRepository repository;
    private final TerminalMapper mapper;

    @Override
    public ApiResponse<TerminalDto> createTerminal(TerminalDto dto) {
        Terminal terminal = mapper.toEntity(dto);
        Terminal saved = repository.save(terminal);


        return ApiResponse.<TerminalDto>builder()
                .success(true)
                .message("ok")
                .content(mapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<TerminalDto> getTerminalById(Long id) {
        Optional<Terminal> optional = repository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<TerminalDto>builder()
                    .message(String.format("Terminal with %d id is not found", id))
                    .code(-3)
                    .success(false)
                    .build();
        }
        return ApiResponse.<TerminalDto>builder()
                .success(true)
                .content(mapper.toDto(optional.get()))
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<TerminalDto> updateTerminalById(TerminalDto dto, Long id) {
        Optional<Terminal> optional = repository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<TerminalDto>builder()
                    .message(String.format("Terminal with %d id is not found", id))
                    .code(-3)
                    .success(false)
                    .build();
        }
        Terminal terminal = mapper.updateAllFields(optional.get(), dto);
        Terminal saved = repository.save(terminal);

        return ApiResponse.<TerminalDto>builder()
                .message("successfully updated")
                .content(mapper.toDto(saved))
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<TerminalDto> deleteTerminalById(Long id) {
        Optional<Terminal> optional = repository.findById(id);
        if (optional.isEmpty()){
            return ApiResponse.<TerminalDto>builder()
                    .message(String.format("Terminal with %d id is not found", id))
                    .code(-3)
                    .success(false)
                    .build();
        }
        repository.delete(optional.get());
        return ApiResponse.<TerminalDto>builder()
                .success(true)
                .content(mapper.toDto(optional.get()))
                .message("ok")
                .build();
    }

    @Override
    public ApiResponse<List<TerminalDto>> getAllTerminals() {
        List<Terminal> terminals = repository.getAll();
        if (terminals.isEmpty()){
            return ApiResponse.<List<TerminalDto>>builder()
                    .success(false)
                    .message("Terminal list is empty")
                    .code(-3)
                    .build();
        }
        return ApiResponse.<List<TerminalDto>>builder()
                .content(mapper.terminalDtoList(terminals))
                .message("ok")
                .success(true)
                .build();
    }
}
