package com.won.dourbest.admin.notice.service;


import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.notice.dao.NoticeMapper;
import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;

import com.won.dourbest.admin.notice.dto.EventRegistDTO;
import com.won.dourbest.admin.notice.dto.NoticeRegistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final NoticeMapper mapper;

    public NoticeServiceImpl(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    // 공지사항 조회
    @Override
    public List<AdminNoticeDTO> selectNoticeList(SelectCriteria selectCriteria) {

        List<AdminNoticeDTO> adminNoticeList = mapper.selectNoticeList(selectCriteria);

        for (int i = 0; i < adminNoticeList.size(); i++){
            if(adminNoticeList.get(i).getNoticeTitle().length()>=30) {
                adminNoticeList.get(i).setNoticeTitle(adminNoticeList.get(i).getNoticeTitle().substring(0, 30));
            }
        }

        System.out.println("adminNoticeList = " + adminNoticeList);

        return adminNoticeList;
    }

    // 진행중인 이벤트 조회
    @Override
    public List<AdminEventDTO> selectOngoingEventList(SelectCriteria selectCriteria) {

        List<AdminEventDTO> adminNoticeList = mapper.selectOngoingEventList(selectCriteria);

        for (int i = 0; i < adminNoticeList.size(); i++){

            if(adminNoticeList.get(i).getEventTitle().length() >= 35) {
                adminNoticeList.get(i).setEventTitle(adminNoticeList.get(i).getEventTitle().substring(0, 35));
            }
        }

        return adminNoticeList;
    }

    // 종료된 이벤트 조회
    @Override
    public List<AdminEventDTO> selectFinshedEventList(SelectCriteria selectCriteria) {

        List<AdminEventDTO> finshedEventList = mapper.selectFinshedEventList(selectCriteria);

        for (int i = 0; i < finshedEventList.size(); i++){
            if(finshedEventList.get(i).getEventTitle().length() >= 35){
                finshedEventList.get(i).setEventTitle(finshedEventList.get(i).getEventTitle().substring(0, 35));
            }
        }
        return finshedEventList;
    }

    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectTotalPage(searchMap);

        return result;
    }

    @Override
    public String insertNotice(NoticeRegistDTO notice) {

        int result = mapper.insertNotice(notice);

        String message = "";

        if(result != 0){
            message = "글 등록에 성공하셨습니다.";
        } else{
            message = "글 등록에 실패하셨습니다.";
        }

        return message;
    }


    // 이벤트 글 등록
    @Override
    public String insertEvent(EventRegistDTO event) {


        int result = mapper.insertEvent(event);

        String message = "";

        if(result != 0){
            message = "글 등록에 성공하셨습니다";
        } else{
            message = "글 등록에 실패하셨습니다";
        }


        return message;

    }

    // 공지사항 삭제
    @Override
    public String deleteNotice(String noticeTitle) {

        String message;
        int result = mapper.deleteNotice(noticeTitle);

        if(result != 0){
            message = "공지사항이 삭제되었습니다";
        } else {
            message = "공지사항 삭제에 실패하셨습니다";
        }



        return message;
    }


}
