package com.won.dourbest.seller.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dao.SellerNoticeMapper;
import com.won.dourbest.seller.dto.SellerNoticeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SellerNoticeServiceImpl implements SellerNoticeService{

    private final SellerNoticeMapper mapper;

    public SellerNoticeServiceImpl ( SellerNoticeMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<SellerNoticeDTO> selectNotice(SelectCriteria selectCriteria) {

        List<SellerNoticeDTO> notice = mapper.selectNotice(selectCriteria);

        return notice;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int search = mapper.selectSearch(searchMap);

        return search;
    }
}
