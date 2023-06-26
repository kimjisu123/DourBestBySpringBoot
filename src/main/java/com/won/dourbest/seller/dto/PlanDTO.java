package com.won.dourbest.seller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlanDTO {

    private int planCode;
    private String planName;
    private int fee;
    private String planContent;
}