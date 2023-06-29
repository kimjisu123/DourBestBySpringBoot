package com.won.dourbest.user.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberSellerInquireDTO {

    private String sellerInqTitle;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sellerInqDate;

    private String sellerInqAnswerStatus;

    private String categoryName;

}
