package com.won.dourbest.common.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {

    private int categoryCode;
    private String categoryName;
    private String categoryKind;
    private String categoryIcon;
}
