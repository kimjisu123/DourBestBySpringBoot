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
    private String noticeTitle;
    private String noticeContent;
    private Date regiDate;
    private int adminCode;

}
