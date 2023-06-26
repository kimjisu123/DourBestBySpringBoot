package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminQnaDTO {

    private int adminQnaCode;
    private String AnswerContent;
    private Date answerDate;
    private AdminDTO AdminCde;
    private AdminInquiriesDTO inquiriesCode;

}
