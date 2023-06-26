package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberAuthDTO {

    private int memberAuthCode;
    private String memberAuthName;
    private String memberAuthDesc;
}
