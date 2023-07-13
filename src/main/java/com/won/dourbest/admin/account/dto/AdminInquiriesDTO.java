package com.won.dourbest.admin.account.dto;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.user.dto.MemberDTO;
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

    private int memberCode;
    private String answerContent;
    private Date answerDate;
}
