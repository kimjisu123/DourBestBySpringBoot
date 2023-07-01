package com.won.dourbest.admin.notice.dao;


import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // 공지사항
    List<AdminNoticeDTO> selectNoticeList();

    List<AdminEventDTO> selectOngoingEventList();

    List<AdminEventDTO> selectFinshedEventList();
}
