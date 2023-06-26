package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberAuthListDTO {

    private int memberAuthCode;
    private int memberCode;

    // 권한
    private MemberAuthDTO memberAuth;
}
