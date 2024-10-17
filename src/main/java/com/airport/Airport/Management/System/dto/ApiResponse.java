package com.airport.Airport.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T>{
    private int code;
    private String message;
    private T content;
    private boolean success;
    private List<ErrorDto> errorDtoList;

}
