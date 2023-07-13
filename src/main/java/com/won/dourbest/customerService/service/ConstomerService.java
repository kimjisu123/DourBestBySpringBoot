package com.won.dourbest.customerService.service;

import com.won.dourbest.admin.account.dto.AdminInquiriesDTO;
import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.customerService.dto.ConstomerContactDTO;

import java.util.List;

public interface ConstomerService {
    List<ConstomerContactDTO> selectContact();

    List<ConstomerContactDTO> selectCoupon();

    List<ConstomerContactDTO> selectDelivery();

    List<ConstomerContactDTO> selecteExchange();

    List<ConstomerContactDTO> selectMember();

    List<ConstomerContactDTO> selectMembership();

    List<ConstomerContactDTO> selectPayment();

    List<ConstomerContactDTO> selectRefund();

    List<ConstomerContactDTO> selectUseService();

    List<CategoryDTO> selectCategory();

    int adminInquire(AdminInquiriesDTO inquire);
}
