package com.won.dourbest.main.model.service;

import com.won.dourbest.admin.dto.EventDTO;
import com.won.dourbest.admin.dto.NoticeDTO;
import com.won.dourbest.main.model.dao.NoticeEventMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeEventServiceImpl implements NoticeEventService {

    private final NoticeEventMapper noticeEventMapper;

    public NoticeEventServiceImpl(NoticeEventMapper noticeEventMapper) {
        this.noticeEventMapper = noticeEventMapper;
    }

    @Override
    public List<NoticeDTO> selectNotice() {

        List<NoticeDTO> noticeList = noticeEventMapper.selectNotice();

        return noticeList;
    }

    @Override
    public NoticeDTO detailNotice(int code) {

        NoticeDTO notice = noticeEventMapper.detailNotice(code);

        return notice;
    }

    @Override
    public List<EventDTO> selectEvent() {

        List<EventDTO> eventList = noticeEventMapper.selectEvent();

        return eventList;
    }

    @Override
    public List<EventDTO> endEvent() {

        List<EventDTO> endEvent = noticeEventMapper.endEvent();

        return endEvent;
    }

    @Override
    public EventDTO detailEvent(int code) {

        EventDTO event = noticeEventMapper.detailEvent(code);

        return event;
    }
}
