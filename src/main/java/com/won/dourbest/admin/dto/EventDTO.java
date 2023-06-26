package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private int eventCode;
    private String eventTitle;
    private String eventContent;
    private Date startDate;
    private Date endDate;
    private int adminCode;

}
