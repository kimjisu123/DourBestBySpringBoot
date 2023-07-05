package com.won.dourbest.admin.notice.service;

import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;

import java.util.List;

public interface NoticeService {

    List<AdminNoticeDTO> selectNoticeList();

    List<AdminEventDTO> selectOngoingEventList();

    List<AdminEventDTO> selectFinshedEventList();
}
