package com.won.dourbest.user.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MypageDTO extends MypageMainDTO{

    private int readyCount;
    private int ingCount;
    private int finishCount;
}
