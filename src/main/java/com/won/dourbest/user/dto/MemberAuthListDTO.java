package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberAuthListDTO {

    private MemberAuthDTO memberAuthCode;
    private MemberDTO memberCode;
}
