package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistListDTO {

    private int blacklistCode;
    private int adminCode;
    private int memberCode;
    private Date additionalDate;
}
