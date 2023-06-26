package com.won.dourbest.admin.dto;


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
