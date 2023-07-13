package com.won.dourbest.seller.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.SellerNoticeDTO;

import java.util.List;
import java.util.Map;

public interface SellerNoticeService {
    List<SellerNoticeDTO> selectNotice(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);
}
