package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.QuestionMapper;
import com.won.dourbest.seller.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper mapper;

    public QuestionServiceImpl (QuestionMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<QuestionDTO> selectQuestion() {

        List<QuestionDTO> question = mapper.selectQuestion();

        System.out.println("question = " + question);

        return question;

    }
}
