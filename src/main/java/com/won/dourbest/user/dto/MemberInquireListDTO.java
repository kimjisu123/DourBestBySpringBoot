package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberInquireListDTO {

    private String contactSubject;
    private Date creationDate;
    private String contactAnswer;
    private String categoryName;

}
