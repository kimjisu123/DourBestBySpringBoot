package com.won.dourbest.admin.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRegistDTO {

    private String adminName;
    private String adminPhone;
    private String adminEmail;
    private String adminPassword;
    private String adminCheckpass;
}
