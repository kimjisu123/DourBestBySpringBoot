package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.MemberDTO;

import java.lang.reflect.Member;

public interface SellerService {


    public Integer registSeller(SellerDTO seller, MemberDTO member);

}
