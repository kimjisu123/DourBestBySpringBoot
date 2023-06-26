package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private int adminCode;
    private String adminEmail;
    private String adminID;
    private String adminPwd;
    private Date regiDate;
}
