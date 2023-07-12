package com.won.dourbest.admin.notice.service;

import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;

import com.won.dourbest.admin.notice.dto.EventRegistDTO;
import com.won.dourbest.admin.notice.dto.NoticeRegistDTO;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    List<AdminNoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    List<AdminEventDTO> selectOngoingEventList(SelectCriteria selectCriteria);

    List<AdminEventDTO> selectFinshedEventList(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);


    String insertNotice(NoticeRegistDTO notice);

    String insertEvent(EventRegistDTO event);

    String deleteNotice(String noticeTitle);
}
