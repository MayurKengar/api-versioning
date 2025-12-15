package com.example.api.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class ApiResponse {
    private String message;
    private Boolean success;
}
