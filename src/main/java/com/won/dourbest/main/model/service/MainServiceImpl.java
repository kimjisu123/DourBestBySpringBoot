package com.won.dourbest.main.model.service;

import com.won.dourbest.common.dto.SearchCriteria;
import com.won.dourbest.main.model.dao.MainMapper;
import com.won.dourbest.main.model.dto.CategoryFundingDTO;
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
  public int totalCount(SearchCriteria searchCriteria) {
    return mainMapper.listCount(searchCriteria);
  }
}
