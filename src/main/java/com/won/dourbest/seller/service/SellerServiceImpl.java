package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.SellerMapper;
import com.won.dourbest.seller.dto.SellerDTO;
import com.won.dourbest.user.dto.MemberDTO;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Member;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerMapper mapper;



    public SellerServiceImpl(SellerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Integer registSeller(SellerDTO seller , MemberDTO member) {

        Integer memberCode = mapper.selectMemberCode(member);

        seller.setMemberCode(memberCode);



        int result = 0;

        if (memberCode != null) {
            result = mapper.insertSeller(seller);
            System.out.println("신청 성공");
        } else if (memberCode == null){
            System.out.println("판매자 신청 실패");
        }

        return memberCode;
    }

}
