package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberSellerInquireDTO {

    private String sellerInqTitle;
    private Date sellerInqDate;
    private String sellerInqAnswerStatus;
    private String categoryName;

}
