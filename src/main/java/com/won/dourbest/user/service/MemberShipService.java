package com.won.dourbest.user.service;

import com.won.dourbest.user.dto.MemberShipCreditDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MemberShipService {


    Optional<MemberShipCreditDTO> findByCredit(int memberCode);

    Optional<MemberShipCreditDTO> memberShipChange(MemberShipCreditDTO credit, int memberCode);




}
