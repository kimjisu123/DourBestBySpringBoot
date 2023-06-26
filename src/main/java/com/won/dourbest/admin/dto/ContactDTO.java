package com.won.dourbest.admin.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private int contactCode;
    private String contactName;
    private String contactDetails;
    private int adminCode;
}
