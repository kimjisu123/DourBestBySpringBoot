package com.won.dourbest.admin.notice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminEventDTO {

    private String eventTitle;
    private Date startDate;
    private Date endDate;
    private int adminCode;
}
