package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dao.jiho.FundingMapper;
import com.won.dourbest.seller.dto.FundingDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FundingServiceImpl implements FundingService{

    private final FundingMapper fundingMapper;

    public FundingServiceImpl(FundingMapper fundingMapper) {
        this.fundingMapper = fundingMapper;
    }

    @Override
    public Map<String, Object> fundingPage(int code) {

        // 펀딩 정보 불러오기
        Map<String, Object> map = new HashMap<>();
        FundPageDTO funding = fundingMapper.selectFunding(code);
        System.out.println("funding = " + funding);

        // 남은 날짜 계산하기
        int goalMoney = funding.getFundingGoalMoney();
        int totalRev = funding.getTotalRev();
        double percen = ((double) totalRev / goalMoney) * 100;
        System.out.println("goalMoney = " + goalMoney);
        System.out.println("totalRev = " + totalRev);
        System.out.println("percent = " + percen);
        Date today = new Date();
        Date endDate = funding.getEndDate();

        double percent = Math.round(percen * 100) / 100.0;

        long remainDate = (endDate.getTime() - today.getTime()) / (24 * 60 * 60 * 1000);
        System.out.println("remainDate = " + remainDate);

        System.out.println("today = " + today);
        map.put("remainDate", remainDate);
        map.put("percent", percent);
        map.put("funding", funding);

        // 태그 불러오기
        List<String> tagList = fundingMapper.selectTag(code);
        map.put("tagList", tagList);

        // 옵션 불러오기
        List<OptionDTO> optionList = fundingMapper.selectOption(code);
        System.out.println(optionList.get(0).getDeliverDate().getClass().getSimpleName());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(optionList.get(0).getDeliverDate());
            String deliverDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(date);
            for(int i = 0; i < optionList.size(); i++) {
                optionList.get(i).setDeliverDate(deliverDate);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        map.put("optionList", optionList);

        // 탑 사진 불러오기
        int categoryCode = fundingMapper.categoryCode(code);

        FundingDTO funding = fundingMapper.selectFunding();

        return map;
    }
}
