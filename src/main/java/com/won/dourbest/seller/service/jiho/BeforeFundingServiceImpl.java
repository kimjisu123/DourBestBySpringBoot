package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.seller.dao.jiho.BeforeFundingMapper;
import com.won.dourbest.seller.dto.MainImgDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BeforeFundingServiceImpl implements BeforeFundingService{

    private final BeforeFundingMapper beforeFundingMapper;

    public BeforeFundingServiceImpl(BeforeFundingMapper beforeFundingMapper) {
        this.beforeFundingMapper = beforeFundingMapper;
    }

    @Override
    public Map<String, Object> getImg() {

        Map<String, Object> imgMap = new HashMap<>();

        List<MainImgDTO> imgList = beforeFundingMapper.getImgName();

        int amount = beforeFundingMapper.getAmount() + 1;

        imgMap.put("imgList", imgList);
        imgMap.put("amount", amount);

        return imgMap;
    }

    @Override
    public int searchAuth(int memberCode) {

        int result = beforeFundingMapper.searchAuth(memberCode);

        return result;
    }


}
