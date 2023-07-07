package com.won.dourbest.admin.notice.dao;


import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    // 공지사항
    List<AdminNoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    List<AdminEventDTO> selectOngoingEventList(SelectCriteria selectCriteria);

    List<AdminEventDTO> selectFinshedEventList(SelectCriteria selectCriteria);

    int selectTotalPage(Map<String, String> searchMap);
}
