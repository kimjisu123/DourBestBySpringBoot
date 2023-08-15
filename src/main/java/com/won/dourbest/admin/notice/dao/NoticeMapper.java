package com.won.dourbest.admin.notice.dao;


import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;
import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;

import com.won.dourbest.admin.notice.dto.EventRegistDTO;
import com.won.dourbest.admin.notice.dto.NoticeRegistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    // 공지사항
    List<AdminNoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    List<AdminEventDTO> selectOngoingEventList(SelectCriteria selectCriteria);

    List<AdminEventDTO> selectFinshedEventList(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);


    // 공지사항 등록
    int insertNotice(String noticeContent, String noticeTitle, int adminCode);

    // 이벤트 글 등록
    int insertEvent(String eventContent, String eventTitle, Date eventEndDate, int adminCode);
    // 공지사항 삭제
    int deleteNotice(String noticeTitle);


    // 진행중인 이벤트 삭제
    int ongoingEventDelete(String eventCode);

    // 종료된 이벤트 글 삭제
    int finishedEventDelete(String eventCode);


    int selectTotalOngoingPage(Map<String, String> searchMap);

    int selectTotalFinshPage(Map<String, String> searchMap);
}
