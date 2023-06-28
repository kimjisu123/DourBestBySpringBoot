package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
    Integer selectMemberCode(MemberDTO member);
    int insertSeller(SellerDTO seller);

}
