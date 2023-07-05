package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {


    List<QuestionDTO> selectQuestion();
}
