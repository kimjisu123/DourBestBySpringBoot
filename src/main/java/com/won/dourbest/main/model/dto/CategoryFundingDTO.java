package com.won.dourbest.main.model.dto;

import com.won.dourbest.seller.dto.FundingFileDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryFundingDTO {

  private int fundingCode;
  private String fundingTitle;
  private String fundingSummary;
  private int views;
  private int likes;
  private Date startDate;
  private Date endDate;
  private int fundingGoalMoney;
  private int categoryCode;
  private String categoryName;
  private String filePath;

}
