package com.won.dourbest.seller.dao.jiho;

import com.won.dourbest.seller.dto.FundPageDTO;
import com.won.dourbest.seller.dto.MainImgDTO;
import com.won.dourbest.seller.dto.OptionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundingMapper {

    FundPageDTO selectFunding(int code);

    List<String> selectTag(int code);

    List<OptionDTO> selectOption(int code);

    String selectFile(int code);

    List<MainImgDTO> topFive(int code, int categoryCode);

    int categoryCode(int code);

//    int findCode(String name);
}
