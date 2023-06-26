package com.won.dourbest.admin.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminAuthlistDTO {
    private int adminCode;
    private int AdminAuthName;

    private AdminAuthDTO adminAuth;
}
