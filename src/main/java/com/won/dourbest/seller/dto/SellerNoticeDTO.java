package com.won.dourbest.seller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SellerNoticeDTO {

    private String noticeTitle;
    private String noticeContent;
    private String MemberId;
    private String regiDate;

}
