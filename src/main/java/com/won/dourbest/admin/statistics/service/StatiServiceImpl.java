package com.won.dourbest.admin.statistics.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.statistics.dao.StatiMapper;
import com.won.dourbest.admin.statistics.dto.StatiDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatiServiceImpl implements StatiService{

    private final StatiMapper mapper;


    public StatiServiceImpl(StatiMapper mapper) {
        this.mapper = mapper;
    }

    // 총 금액 순으로 조회
    @Override
    public List<StatiDTO> selectAllPrice(SelectCriteria selectCriteria) {

        List<StatiDTO> statiAllPriceList = mapper.selectAllPrice(selectCriteria);

        return statiAllPriceList;
    }



    // 총 조회수 순으로 조회

    @Override
    public List<StatiDTO> selectAllViews(SelectCriteria selectCriteria) {

        List<StatiDTO> statiAllViewsList = mapper.selectAllViews(selectCriteria);

        return statiAllViewsList;
    }

    // 총 좋아요 순으로 조회
    @Override
    public List<StatiDTO> selectAllLikes(SelectCriteria selectCriteria) {

        List<StatiDTO> statiallLikesList = mapper.selectAllLikes(selectCriteria);

        return statiallLikesList;
    }

    // 월 기준 금액순으로 조회
    @Override
    public List<StatiDTO> selectMonthPrice(SelectCriteria selectCriteria) {

        List<StatiDTO> statiMonthPriceList = mapper.selectMonthPrice(selectCriteria);

        return statiMonthPriceList;
    }

    // 월 기준 조회수 순으로 조회
    @Override
    public List<StatiDTO> selectMonthViews(SelectCriteria selectCriteria) {

        List<StatiDTO> statiMonthViewsList = mapper.selectMonthViews(selectCriteria);

        return statiMonthViewsList;
    }

    // 월 기준 좋아요 순으로 조회
    @Override
    public List<StatiDTO> selectMonthLikes(SelectCriteria selectCriteria) {

        List<StatiDTO> statiMonthLikesList =  mapper.selectMonthLikes(selectCriteria);
        return statiMonthLikesList;
    }

    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectTotalPage(searchMap);

        return result;
    }


}
