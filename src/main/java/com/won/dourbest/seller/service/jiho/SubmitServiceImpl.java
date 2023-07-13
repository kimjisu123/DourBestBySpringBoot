package com.won.dourbest.seller.service.jiho;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.seller.dao.jiho.SellerFundingMapper;
import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.PlanDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubmitServiceImpl implements SubmitService{

    private SellerFundingMapper sellerFundingMapper;

    public SubmitServiceImpl(SellerFundingMapper sellerFundingMapper) {
        this.sellerFundingMapper = sellerFundingMapper;
    }

    @Override
    public List<PlanDTO> allPlan() {

        return sellerFundingMapper.allPlan();
    }

    @Override
    @Transactional
    public int insertTag(String[] sarr) {

        int count = 0;

        for(int i = 0; i < sarr.length; i++) {
            String tag = sarr[i].trim();
            System.out.println(tag);
            Integer result = sellerFundingMapper.selectTag(tag);
            System.out.println(result);


            if(result == null) {
                int num = sellerFundingMapper.insertTag(tag);
                count += num;
            } else {
                System.out.println(tag + "는 이미 있는 태그입니다.");
            }
            System.out.println(count);
        }
        return count;
    }

    @Override
    public List<CategoryDTO> getFundCategory() {

        return sellerFundingMapper.getFundCategory();
    }

    @Override
    @Transactional
    public Map<String, Integer> insertAboutFunding(Map<String, Object> tossMap) {

        int sellerCode = sellerFundingMapper.selectSeller(tossMap);

        tossMap.put("sellerCode", sellerCode);

        int result = sellerFundingMapper.insertFunding(tossMap);

        int list = sellerFundingMapper.insertStatusList();
        System.out.println("tossMap = " + tossMap);
        int result1 = sellerFundingMapper.insertMainFile(tossMap);

        int result2 = sellerFundingMapper.insertTopFile(tossMap);

        int result3 = sellerFundingMapper.insertContentFile(tossMap);



        Integer result4 = 0;
        String tagList = (String) tossMap.get("tagList");
        String[] sarr = tagList.split(",");
        for(int i = 0; i < sarr.length; i++) {
            String tag = sarr[i].trim();
            Integer num = sellerFundingMapper.selectTag(tag);
            System.out.println("num = " + num);
            result4 = sellerFundingMapper.insertTagList(num);
        }

        int num = 0;

        if(result > 0 && result1 > 0 && result2 > 0 && result3 > 0) {
            num = 1;
        } else {
            num = 0;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("result", num);
        map.put("currentKey", (Integer) tossMap.get("currkey"));

        return map;
    }

    @Override
    public int insertOption(FundingOptionDTO option) {

        int result = sellerFundingMapper.insertOption(option);

        int num = 0;

        if(result > 0) {
            num = 1;
        } else {
            num = 0;
        }

        return num;
    }

    @Override
    public int deleteOption(Map<String, String> map) {

        int result = sellerFundingMapper.deleteOption(map);

        return result > 0? 1 : 0;
    }

    @Override
    public int updateSeller(Map<String, Object> map) {

        int result = sellerFundingMapper.updateSeller(map);

        return result > 0? 1 : 0;
    }

    @Override
    public int updateFunding(Map<String, Object> map) {

        int result = sellerFundingMapper.updateFunding(map);

        return result > 0? 1 : 0;
    }
}

