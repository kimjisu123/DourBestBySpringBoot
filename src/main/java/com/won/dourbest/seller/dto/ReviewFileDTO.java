package com.won.dourbest.seller.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewFileDTO {

    private int reviewFileCode;
    private String fileOriginalName;
    private String fileModificationName;
    @Nullable
    private Date uploadDate;
    private char deletionStatus;
    private int reviewCode;
}
