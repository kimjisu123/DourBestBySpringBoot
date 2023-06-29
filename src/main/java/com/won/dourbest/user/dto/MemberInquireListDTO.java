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

    private String contactSubject;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate;

    private String contactAnswer;

    private String categoryName;

}
