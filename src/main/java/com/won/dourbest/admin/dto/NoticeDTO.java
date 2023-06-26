package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
    private int noticeCode;
    private String noticeName;
    private String noticeContent;
    private Date noticeRegiDate;
    private int adminCode;
}
