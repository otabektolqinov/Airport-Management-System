package com.airport.Airport.Management.System.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T>{
    private int code;
    private String message;
    private T content;
    private boolean success;
    private List<ErrorDto> errorDtoList;

}
