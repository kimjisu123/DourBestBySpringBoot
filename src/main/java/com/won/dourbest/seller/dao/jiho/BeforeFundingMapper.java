package com.won.dourbest.seller.dao.jiho;

import com.won.dourbest.seller.dto.MainImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BeforeFundingMapper {
    List<MainImgDTO> getImgName();

    int getAmount();
}
