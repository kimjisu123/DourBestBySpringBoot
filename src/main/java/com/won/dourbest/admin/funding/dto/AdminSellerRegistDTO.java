package com.won.dourbest.admin.funding.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminSellerRegistDTO {

    private String memberId;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String businessLicense;
    private Date sellerDate;

}
