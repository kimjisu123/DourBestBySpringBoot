package com.won.dourbest.user.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberAuthDTO {

    private int memberAuthCode;
    private String memberAuthName;
    private String memberAuthDesc;

}
