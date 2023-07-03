package com.won.dourbest.common.dto;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private boolean isSuccess;
    private String message;

}
