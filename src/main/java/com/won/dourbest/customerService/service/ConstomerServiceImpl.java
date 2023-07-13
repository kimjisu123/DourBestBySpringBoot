package com.won.dourbest.customerService.service;

import com.won.dourbest.admin.account.dto.AdminInquiriesDTO;
import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.customerService.dao.ConstomerMapper;
import com.won.dourbest.customerService.dto.ConstomerContactDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstomerServiceImpl implements ConstomerService {

    private final ConstomerMapper mapper;
    public ConstomerServiceImpl(ConstomerMapper mapper) {
        this.mapper = mapper;
    }

    // 자주 찾는 도움말
    @Override
    public List<ConstomerContactDTO> selectContact() {

        List<ConstomerContactDTO> contactList =  mapper.selectContact();

        return contactList;
    }

    // 자주 찾는 도움말(쿠폰)
    @Override
    public List<ConstomerContactDTO> selectCoupon() {
        List<ConstomerContactDTO> couponList =  mapper.selectCoupon();

        return couponList;
    }
    // 자주 찾는 도움말(상품)
    @Override
    public List<ConstomerContactDTO> selectDelivery() {

        List<ConstomerContactDTO> deliveryList =  mapper.selectDelivery();

        return deliveryList;
    }
    // 자주 찾는 도움말(교환)
    @Override
    public List<ConstomerContactDTO> selecteExchange() {

        List<ConstomerContactDTO> exchangeList =  mapper.selecteExchange();

        return exchangeList;
    }
    // 자주 찾는 도움말(회원정보)
    @Override
    public List<ConstomerContactDTO> selectMember() {

        List<ConstomerContactDTO> memberList =  mapper.selectMember();

        return memberList;
    }

    // 자주 찾는 도움말(멤버십)
    @Override
    public List<ConstomerContactDTO> selectMembership() {

        List<ConstomerContactDTO> membershipList =  mapper.selectMembership();

        return membershipList;
    }
    // 자주 찾는 도움말(결제)
    @Override
    public List<ConstomerContactDTO> selectPayment() {

        List<ConstomerContactDTO> paymentList =  mapper.selectPayment();

        return paymentList;
    }
    // 자주 찾는 도움말(취소 환불 반품)
    @Override
    public List<ConstomerContactDTO> selectRefund() {

        List<ConstomerContactDTO> refundList =  mapper.selectRefund();

        return refundList;
    }
    // 자주 찾는 도움말(서비스 이용 문의)
    @Override
    public List<ConstomerContactDTO> selectUseService() {

        List<ConstomerContactDTO> useServiceList =  mapper.selectUseService();

        return useServiceList;
    }

    @Override
    public List<CategoryDTO> selectCategory() {
        return mapper.fundingCategory();
    }

    @Override
    public int adminInquire(AdminInquiriesDTO inquire) {
        return mapper.insertAdminInquire(inquire);
    }
}
