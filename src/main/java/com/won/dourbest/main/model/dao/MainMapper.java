package com.won.dourbest.main.model.dao;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.main.model.dto.CategoryFundingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {

  List<CategoryFundingDTO> fundingCategory(@Param("cri") SearchCriteria searchCriteria);

  int listCount(@Param("cri") SearchCriteria searchCriteria);

}
