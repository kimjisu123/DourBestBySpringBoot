package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminInquiriesDTO {
    private int inquiriesCode;
    private String contactSubject;
    private String contactDetails;
    private Date dateCreationInquiry;
    private char whetherAnswer;
    private int categoryCode;

    private CategoryDTO categoryDTO;
}
