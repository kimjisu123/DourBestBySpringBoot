package com.won.dourbest.admin.statistics.service;

import com.won.dourbest.admin.statistics.dao.StatiMapper;
import com.won.dourbest.admin.statistics.dto.StatiDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatiServiceImpl implements StatiService{

    private final StatiMapper mapper;


    public StatiServiceImpl(StatiMapper mapper) {
        this.mapper = mapper;
    }

    // 총 금액 순으로 조회
    @Override
    public List<StatiDTO> selectAllPrice() {

        List<StatiDTO> statiAllPriceList = mapper.selectAllPrice();

        return statiAllPriceList;
    }



    // 총 조회수 순으로 조회

    @Override
    public List<StatiDTO> selectAllViews() {

        List<StatiDTO> statiAllViewsList = mapper.selectAllViews();

        return statiAllViewsList;
    }

    // 총 좋아요 순으로 조회
    @Override
    public List<StatiDTO> selectAllLikes() {

        List<StatiDTO> statiallLikesList = mapper.selectAllLikes();

        return statiallLikesList;
    }

    // 월 기준 금액순으로 조회
    @Override
    public List<StatiDTO> selectMonthPrice() {

        List<StatiDTO> statiMonthPriceList = mapper.selectMonthPrice();

        return statiMonthPriceList;
    }

    // 월 기준 조회수 순으로 조회
    @Override
    public List<StatiDTO> selectMonthViews() {

        List<StatiDTO> statiMonthViewsList = mapper.selectMonthViews();

        return statiMonthViewsList;
    }

    // 월 기준 좋아요 순으로 조회
    @Override
    public List<StatiDTO> selectMonthLikes() {

        List<StatiDTO> statiMonthLikesList =  mapper.selectMonthLikes();
        return statiMonthLikesList;
    }


}
