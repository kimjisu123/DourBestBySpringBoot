package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private int addressCode;
    private int zipCode;
    private String baseAddress;
    private String detailAddress;
    private MemberDTO memberCode;

}
