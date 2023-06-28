package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dao.jiho.SellerMapper;
import com.won.dourbest.seller.dto.PlanDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubmitServiceImpl implements SubmitService{

    private SellerMapper sellerMapper;

    public SubmitServiceImpl(SellerMapper sellerMapper) {
        this.sellerMapper = sellerMapper;
    }

    @Override
    public List<PlanDTO> allPlan() {

        return sellerMapper.allPlan();
    }

    @Override
    @Transactional
    public int insertTag(String[] sarr) {

            int count = 0;

        for(int i = 0; i < sarr.length; i++) {
            String tag = sarr[i].trim();
            System.out.println(tag);
            int result = sellerMapper.selectTag(tag);
            System.out.println(result);


            if(result == 0) {
                int num = sellerMapper.insertTag(tag);
                count += num;
            } else {
                System.out.println(tag + "는 이미 있는 태그입니다.");
            }
            System.out.println(count);
        }
        return count;
    }
}
