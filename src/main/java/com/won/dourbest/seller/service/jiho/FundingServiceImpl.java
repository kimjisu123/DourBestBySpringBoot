package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dao.jiho.FundingMapper;
import com.won.dourbest.seller.dto.FundingDTO;

import java.util.HashMap;
import java.util.Map;

public class FundingServiceImpl implements FundingService{

    private final FundingMapper fundingMapper;

    public FundingServiceImpl(FundingMapper fundingMapper) {
        this.fundingMapper = fundingMapper;
    }

    @Override
    public Map<String, Object> fundingPage() {

        Map<String, Object> map = new HashMap<>();

        FundingDTO funding = fundingMapper.selectFunding();

        return map;
    }
}
