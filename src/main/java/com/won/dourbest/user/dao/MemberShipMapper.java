package com.won.dourbest.user.dao;

import com.won.dourbest.user.dto.MemberShipCreditDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberShipMapper {

    int memberShipUpdate(int memberCode);

    Optional<MemberShipCreditDTO> findByCredit(int memberCode);

    int insertCredit(MemberShipCreditDTO memberShipCreditDTO);


}
