package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckMemberDTO {

    private String memberId;

    private String memberPwd;
}
