package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dao.jiho.FundingMapper;
import com.won.dourbest.seller.dto.FundPageDTO;
import com.won.dourbest.seller.dto.MainImgDTO;
import com.won.dourbest.seller.dto.OptionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Map<String, Object> map = new HashMap<>();

        int status = fundingMapper.selectStatus(code);
        map.put("status", status);
        // 펀딩 정보 불러오기
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

        String topImg = fundingMapper.selectFile(code);
        map.put("topImg",topImg);

        List<MainImgDTO> mainImg = fundingMapper.topFive(code, categoryCode);
        map.put("mainImg", mainImg);

        String sellerName = fundingMapper.selectId(code);
        map.put("sellerId", sellerName);


        return map;
    }

    @Override
    public int addLikes(int fundingCode, int memberCode) {

        int result = fundingMapper.addLikes(fundingCode, memberCode);

        return result > 0? 1 : 0;
    }

    @Override
    public int deleteLikes(int fundingCode, int memberCode) {

        int result = fundingMapper.deleteLikes(fundingCode, memberCode);

        return result > 0? 1 : 0;
    }

    @Override
    public int selectLikes(int code, int memberCode) {

        int returnCode = 0;

        int result = fundingMapper.selectLikes(code, memberCode);

        if(result == 1) {
            returnCode = 1;
        } else if(result == 0) {
            returnCode = -1;
        }

        return returnCode;
    }

    @Override
    @Transactional
    public String insertReport(Map<String, Object> map) {

        String category = (String) map.get("category");

        Integer categoryCode = fundingMapper.selectCategory(category);

            String message = "";

        if (categoryCode != null) {

            map.put("categoryCode", categoryCode);

            int result = fundingMapper.insertReport(map);

            if(result > 0) {
                message = "신고 성공";
            } else {
                message = "신고 실패";
            }
        } else {
            message = "신고 실패";
        }

        return message;
    }

    @Override
    public int selectReport(int code, int memberCode) {

        int result = 0;

        int num = fundingMapper.selectReport(code, memberCode);

        System.out.println("num = " + num);
        if(num > 0) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }

    @Override
    public String selectProfile(int code) {

        int sellerCode = fundingMapper.selectSellerCode(code);

        int memberCode = fundingMapper.selectMemberCode(sellerCode);

        String profile = fundingMapper.selectProfile(memberCode);

        return profile;
    }

    @Override
    public Map<String, Object> selectRefund(int code) {

        Map<String, Object> map = new HashMap<>();
        String refund = fundingMapper.selectRefund(code);
        Date startDate = fundingMapper.startDate(code);
        Date endDate = fundingMapper.endDate(code);
        String email = fundingMapper.email(code);

        map.put("refund", refund);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("email", email);

        return map;
    }
}
