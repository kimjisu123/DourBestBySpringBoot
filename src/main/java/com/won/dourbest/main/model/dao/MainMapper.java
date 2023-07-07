package com.won.dourbest.main.model.dao;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.main.model.dto.CategoryFundingDTO;
import com.won.dourbest.user.dto.LikeFundingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {

  List<CategoryFundingDTO> fundingCategory(@Param("cri") SearchCriteria searchCriteria);

  int listCount(@Param("cri") SearchCriteria searchCriteria);

  List<LikeFundingDTO> getSlideImages();

  List<LikeFundingDTO> ToplikeFundings();

  List<LikeFundingDTO> OpenFundings();

  List<LikeFundingDTO> EndFundings();


}
