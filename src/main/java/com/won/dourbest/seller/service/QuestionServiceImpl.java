package com.won.dourbest.seller.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.seller.dao.QuestionMapper;
import com.won.dourbest.seller.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper mapper;

    public QuestionServiceImpl (QuestionMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<QuestionDTO> selectQuestion(SelectCriteria selectCriteria) {

        List<QuestionDTO> question = mapper.selectQuestion(selectCriteria);

        System.out.println("question = " + question);

        return question;

    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int search = mapper.selectSearch(searchMap);

        return search;
    }
}
