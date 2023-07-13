package com.won.dourbest.seller.dao;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dto.SellerNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SellerNoticeMapper {
    List<SellerNoticeDTO> selectNotice(SelectCriteria selectCriteria);

    int selectSearch(Map<String, String> searchMap);
}
