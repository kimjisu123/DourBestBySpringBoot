package com.won.dourbest.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {

    private int addressCode;
    private int zipcode;
    private String baseAddress;
    private String detailAddress;
    private MemberDTO memberCode;

}