package com.won.dourbest.admin.notice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminNoticeDTO {
    private int noticeCode;
    private String noticeTitle;
    private Date regiDate;
    private int adminCode;
}
