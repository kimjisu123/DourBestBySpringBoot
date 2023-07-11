package com.won.dourbest.main.model.dao;

import com.won.dourbest.admin.dto.EventDTO;
import com.won.dourbest.admin.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeEventMapper {
    List<NoticeDTO> selectNotice();

    NoticeDTO detailNotice(int code);

    List<EventDTO> selectEvent();

    List<EventDTO> endEvent();

    EventDTO detailEvent(int code);
}
