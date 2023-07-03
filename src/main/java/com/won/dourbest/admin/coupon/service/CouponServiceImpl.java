package com.won.dourbest.admin.coupon.service;

import com.won.dourbest.admin.coupon.dao.CouponMapper;
import com.won.dourbest.admin.coupon.dto.CouponIssuance;
import com.won.dourbest.admin.coupon.dto.UseCoupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService{

    private final CouponMapper mapper;
    public CouponServiceImpl(CouponMapper mapper) {
        this.mapper = mapper;
    }

    // 쿠폰 발급 내역
    @Override
    public List<CouponIssuance> selectIssuanceList() {

        List<CouponIssuance> couponIssuanceList = mapper.selectIssuanceList();

        System.out.println("couponIssuanceList = " + couponIssuanceList);
        
        
        // 문자열을 정수로 변환을 하지만 변환을 하지 못했을시의 예외 처리를 해준다.
        for(int i=0; i<couponIssuanceList.size(); i++){
            try {
                if (Integer.valueOf(couponIssuanceList.get(i).getCouponDiscount()) > 101) {
                    couponIssuanceList.get(i).setCouponDiscount("무료배송");
                }
            } catch (Exception e) {

            }

        }

         return couponIssuanceList;
    }

    // 쿠폰 사용 내역
    @Override
    public List<UseCoupon> selectUseCoupon() {

        List<UseCoupon> useCoupon = mapper.selectUseCoupon();

        // 문자열을 정수로 변환을 하지만 변환을 하지 못했을시의 예외 처리를 해준다.
        for(int i=0; i<useCoupon.size(); i++){
                try {
                    if (Integer.valueOf(useCoupon.get(i).getCouponDiscount()) > 101) {
                        useCoupon.get(i).setCouponDiscount("무료배송");
                    }
                } catch (Exception e) {

                }
            }



        return useCoupon;
    }
}
