package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {
    List<QuestionDTO> selectQuestion();
}
