package com.won.dourbest.user.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberPointDTO {

  private int rowNum;
  private Date pointDate;
  private int pointAmount;
  private String status;
  private int orderCode;
  private String fundingTitle;


}
