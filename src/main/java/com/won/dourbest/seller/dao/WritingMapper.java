package com.won.dourbest.seller.dao;

import com.won.dourbest.seller.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WritingMapper {
    int registWriting(QuestionDTO question);

    int registNoticeWriting(QuestionDTO question);
}
