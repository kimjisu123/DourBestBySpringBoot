package com.won.dourbest.admin.account.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminAuthDTO {

    private int adminAuthName;
    private String authName;

    private String authDesc;
}
