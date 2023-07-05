package com.won.dourbest.seller.dao.jiho;

import com.won.dourbest.seller.dto.FundPageDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FundingMapper {

    FundPageDTO selectFunding(int code);
}
