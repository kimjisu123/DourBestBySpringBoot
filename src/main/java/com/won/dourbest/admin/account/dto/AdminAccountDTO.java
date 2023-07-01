package com.won.dourbest.admin.account.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminAccountDTO {

    private int adminCode;
    private String adminEmail;
    private String adminId;
    private String adminPwd;
    private Date regiDate;
}
