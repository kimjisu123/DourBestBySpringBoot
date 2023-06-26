package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {

    private int noticeCode;
    private String noticeTitle;
    private int noticeContent;

    private Date noticeRegiDate;
    private AdminDTO adminCode;
}
