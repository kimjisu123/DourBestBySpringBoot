package com.won.dourbest.admin.account.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminAccountDTO {

    private int adminCode;
    private String adminEmail;
    private Date regiDate;
    private String adminPhone;
    private String adminName;
    private String adminPwd;

    private List<AdminAuthListDTO> adminAuthList;


}
