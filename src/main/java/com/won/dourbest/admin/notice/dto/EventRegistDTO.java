package com.won.dourbest.admin.notice.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventRegistDTO {

    private String eventTitle;
    private String eventContent;
    private Date eventEndDate;
}
