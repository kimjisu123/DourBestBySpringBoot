package com.won.dourbest.main.model.service;

import com.won.dourbest.admin.dto.EventDTO;
import com.won.dourbest.admin.dto.NoticeDTO;

import java.util.List;

public interface NoticeEventService {
    List<NoticeDTO> selectNotice();

    NoticeDTO detailNotice(int code);

    List<EventDTO> selectEvent();

    List<EventDTO> endEvent();

    EventDTO detailEvent(int code);
}
