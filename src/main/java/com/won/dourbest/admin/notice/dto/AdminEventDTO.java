package com.won.dourbest.admin.notice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminEventDTO {
    private int eventCode;
    private String eventTitle;
    private String eventContent;
    private Date startDate;
    private Date endDate;
    private int adminCode;
    private int rowNum;
}
