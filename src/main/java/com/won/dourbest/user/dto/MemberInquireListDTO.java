package com.won.dourbest.user.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberInquireListDTO {

    private int rowNum;
    private int inquiriesCode;

    private String contactSubject;

    private Date creationDate;

    private String contactAnswer;

    private String categoryName;

}
