package com.won.dourbest.admin.statistics.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StatiDTO {

    private String memberId;
    private String memberEmail;
    private String fundingTitle;
    private int totalPrice;
    private int likes;
    private int views;
}
