package com.won.dourbest.admin.coupon.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.coupon.dao.CouponMapper;
import com.won.dourbest.admin.coupon.dto.CouponIssuanceDTO;
import com.won.dourbest.admin.coupon.dto.CouponRegistDTO;
import com.won.dourbest.admin.coupon.dto.UseCouponDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{

    private final CouponMapper mapper;
    public CouponServiceImpl(CouponMapper mapper) {
        this.mapper = mapper;
    }

    // 쿠폰 발급 내역
    @Override
    public List<CouponIssuanceDTO> selectIssuanceList(SelectCriteria selectCriteria) {

        List<CouponIssuanceDTO> couponIssuanceList = mapper.selectIssuanceList(selectCriteria);

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

    // 쿠폰 등록 내역
    @Override
    public List<UseCouponDTO> selectUseCoupon(SelectCriteria selectCriteria) {

        List<UseCouponDTO> useCoupon = mapper.selectUseCoupon(selectCriteria);

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

    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectTotalPage(searchMap);

        return result;
    }




    // 쿠폰 등록 및 발급
    @Override
    public String couponRegist(CouponRegistDTO coupon) {

        int result;

        int result2 = 0;

            // 쿠폰 생성()
            result = mapper.couponRegist(coupon);


            // 쿠폰이 정상적으로 생성이 됐을 시
            if(result != 0){

                // 모든 회원의 memberCode 조회
                List<Integer> memberCodes = mapper.selectAllMemberCodes();
                System.out.println("memberCodes = " + memberCodes);
                Map<String, Object> insertMap = new HashMap<>();

                for (int i = 0; i < memberCodes.size(); i++) {

                    Date date = coupon.getCouponVaildDate();
                    int memCode = memberCodes.get(i);

                    result2 = mapper.insertCoupon(date, memCode);
                }

                if(result2 != 0){
                    return "쿠폰 발급에 성공하셨습니다";
                }  else{
                    throw new RuntimeException();
                }

            }

            // 쿠폰을 생성하지 못했을 시
            else{
                throw new RuntimeException();
            }

    }

    @Override
    public int selectRegiTotalPage(Map<String, String> searchMap) {

        int reusult = mapper.selectRegiTotalPage();

        return reusult;
    }

}
