package com.won.dourbest.main.model.service;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.main.model.dao.MainMapper;
import com.won.dourbest.main.model.dto.CategoryFundingDTO;
import com.won.dourbest.user.dto.LikeFundingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{

  private final MainMapper mainMapper;

  @Override
  public List<CategoryFundingDTO> categoryList(SearchCriteria searchCriteria) {
    return mainMapper.fundingCategory(searchCriteria);
  }

  @Override
  public List<CategoryFundingDTO> openFundingList(SearchCriteria searchCriteria) {
    return mainMapper.openFundingCate(searchCriteria);
  }

  @Override
  public int totalCount(SearchCriteria searchCriteria, String name) {
    return mainMapper.listCount(searchCriteria, name);
  }

  @Override
  public List<LikeFundingDTO> getSlideImages() {


    return mainMapper.getSlideImages();
  }

  @Override
  public List<LikeFundingDTO> ToplikeFundings() {
    return mainMapper.ToplikeFundings();
  }

  @Override
  public List<LikeFundingDTO> OpenFundings() {
    return mainMapper.OpenFundings();
  }

  @Override
  public List<LikeFundingDTO> EndFundings() {
    return mainMapper.EndFundings();
  }

}
