package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dao.jiho.FundingMapper;
import com.won.dourbest.seller.dto.FundPageDTO;
import com.won.dourbest.seller.dto.FundingDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FundingServiceImpl implements FundingService{

    private final FundingMapper fundingMapper;

    public FundingServiceImpl(FundingMapper fundingMapper) {
        this.fundingMapper = fundingMapper;
    }

    @Override
    public Map<String, Object> fundingPage(int code) {

        Map<String, Object> map = new HashMap<>();
        FundPageDTO funding = fundingMapper.selectFunding(code);
        System.out.println("funding = " + funding);

        int goalMoney = funding.getFundingGoalMoney();
        int totalRev = funding.getTotalRev();
        double percent = ((totalRev / goalMoney) * 100);
        System.out.println("goalMoney = " + goalMoney);
        System.out.println("totalRev = " + totalRev);
        System.out.println("percent = " + percent);
        map.put("percent", (int)percent);

        map.put("funding", funding);
        return map;
    }
}
