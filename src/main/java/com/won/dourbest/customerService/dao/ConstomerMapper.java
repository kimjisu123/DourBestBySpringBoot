package com.won.dourbest.customerService.dao;

import com.won.dourbest.customerService.dto.ConstomerContactDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConstomerMapper {

    // 자주 찾는 도움말
    List<ConstomerContactDTO> selectContact();

    // 쿠폰
    List<ConstomerContactDTO> selectCoupon();
    // 배송
    List<ConstomerContactDTO> selectDelivery();
    // 교환
    List<ConstomerContactDTO> selecteExchange();
    // 회원정보
    List<ConstomerContactDTO> selectMember();
    // 멤버십
    List<ConstomerContactDTO> selectMembership();
    // 결제
    List<ConstomerContactDTO> selectPayment();
    // 환불
    List<ConstomerContactDTO> selectRefund();
    // 이용 서비스
    List<ConstomerContactDTO> selectUseService();
}
