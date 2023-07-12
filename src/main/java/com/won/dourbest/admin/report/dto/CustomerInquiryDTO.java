package com.won.dourbest.admin.report.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CustomerInquiryDTO {

    private String contactSubject;
    private String contactDetails;
    private Date dateCreationInquiry;
    private Date answerDate;


}
