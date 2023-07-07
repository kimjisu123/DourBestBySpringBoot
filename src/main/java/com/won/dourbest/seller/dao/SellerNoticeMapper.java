package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.SellerNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerNoticeMapper {
    List<SellerNoticeDTO> selectNotice();
}
