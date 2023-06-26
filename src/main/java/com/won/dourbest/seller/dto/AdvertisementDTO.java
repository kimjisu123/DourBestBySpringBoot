package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdvertisementDTO {

    private int advertisementCode;
    private java.util.Date adStartDate;
    private java.util.Date adEndDate;
    private FundingDTO funding;

}
