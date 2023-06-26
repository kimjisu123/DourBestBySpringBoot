package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class AdminInquiriesDTO {
    private int inquiresCode;
    private String contactSubject;

    private String  contactDetails;
    private Date dateCreationInquiry;
    private char whetherAnswer;

    private Category categoryCode;

}
