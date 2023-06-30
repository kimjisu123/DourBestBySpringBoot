package com.won.dourbest.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse {

    private boolean isSuccess;
    private String message;

}
