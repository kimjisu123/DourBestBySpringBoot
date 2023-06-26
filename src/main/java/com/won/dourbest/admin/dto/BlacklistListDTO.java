package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlacklistListDTO {

    private int blacklistCode;
    private AdminDTO adminCode;
    private MemberDTO memberCode;
    private Date addtionalDate;
}
