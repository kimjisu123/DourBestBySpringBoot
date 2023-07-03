package com.won.dourbest.user.service;

import com.won.dourbest.common.exception.user.ExistenceCreditException;
import com.won.dourbest.user.dao.MemberShipMapper;
import com.won.dourbest.user.dto.MemberShipCreditDTO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberShipServiceImpl implements MemberShipService{

    private final MemberShipMapper memberShipMapper;

    @Override
    public Optional<MemberShipCreditDTO> findByCredit(int memberCode) {
        Optional<MemberShipCreditDTO> findCredit = memberShipMapper.findByCredit(memberCode);

        if(findCredit.isPresent() && findCredit.get().getMemberStatus().equals("paid")){
            throw new ExistenceCreditException("이미 프리미엄회원입니다.");
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<MemberShipCreditDTO> memberShipChange(MemberShipCreditDTO credit, int memberCode) {



        memberShipMapper.memberShipUpdate(memberCode);
        memberShipMapper.insertCredit(credit);

        return Optional.ofNullable(credit);



    }
}
