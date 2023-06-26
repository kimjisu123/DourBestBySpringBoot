package com.won.dourbest.admin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private int contactCode;
    private String ContactName;
    private String ContactDetails;
    private AdminDTO adminCode;
}
