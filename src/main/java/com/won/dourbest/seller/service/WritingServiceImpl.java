package com.won.dourbest.seller.service;

import com.won.dourbest.seller.dao.WritingMapper;
import com.won.dourbest.seller.dto.QuestionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WritingServiceImpl implements WritingService{

    private final WritingMapper mapper;

    public WritingServiceImpl (WritingMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public int registWriting(QuestionDTO question) {

        if(question.getCategoryName().equals("배송관련문의")){
            question.setCategoryName(String.valueOf(20));
        } else {
            question.setMemberName("21");
        }
        int writing = mapper.registWriting(question);


        if (writing >= 1) {
            System.out.println("글작성 성공");
        } else {
            System.out.println("글작성 실패");
        }

        return writing;
    }

    @Override
    public void registNoticeWriting(QuestionDTO question) {

        int writing = mapper.registNoticeWriting(question);
    }
}
