package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.SellerNoticeDTO;

import java.util.List;

public interface SellerNoticeService {
    List<SellerNoticeDTO> selectNotice();
}
