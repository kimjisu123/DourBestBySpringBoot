package com.won.dourbest.seller.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AdvertisementDTO {

    private int advertisementCode;
    private Date adStartDate;
    private Date adEndDate;
    private FundingDTO funding;
}
