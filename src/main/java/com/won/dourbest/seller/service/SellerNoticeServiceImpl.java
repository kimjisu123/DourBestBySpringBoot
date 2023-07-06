package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.SellerNoticeMapper;
import com.won.dourbest.seller.dto.SellerNoticeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerNoticeServiceImpl implements SellerNoticeService{

    private final SellerNoticeMapper mapper;

    public SellerNoticeServiceImpl ( SellerNoticeMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<SellerNoticeDTO> selectNotice() {

        List<SellerNoticeDTO> notice = mapper.selectNotice();

        return notice;
    }
}
