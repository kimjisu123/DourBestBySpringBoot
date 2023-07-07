package com.won.dourbest.admin.account.dto;

import com.won.dourbest.user.dto.MemberAuthDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminAuthListDTO {

    private int adminAuthName;
    private int adminCode;


    private AdminAuthDTO adminAuth;
}
