package com.won.dourbest.admin.dto;

import com.won.dourbest.admin.account.dto.AdminInquiriesDTO;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminQnaDTO {

    private int adminQnaCode;
    private String answerContent;
    private Date answerDate;
    private int adminCode;
    private int inquiriesCode;

    private AdminInquiriesDTO adminInquiriesDTO;

}
