package com.airport.Airport.Management.System.dto;

import java.util.List;

public class ApiResponse<T>{
    private int code;
    private String message;
    private T content;
    private boolean success;
    private List<ErrorDto> errorDtoList;

}
