package com.won.dourbest.seller.dao.jiho;

import com.won.dourbest.seller.dto.FundingDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FundingMapper {

    FundingDTO selectFunding();
}
