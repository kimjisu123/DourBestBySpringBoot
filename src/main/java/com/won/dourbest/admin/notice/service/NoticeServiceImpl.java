package com.won.dourbest.admin.notice.service;


import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.notice.dao.NoticeMapper;
import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
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

            adminNoticeList.get(i).setNoticeTitle(adminNoticeList.get(i).getNoticeTitle().substring(0, 30));
        }

        System.out.println("adminNoticeList = " + adminNoticeList);

        return adminNoticeList;
    }

    // 진행중인 이벤트 조회
    @Override
    public List<AdminEventDTO> selectOngoingEventList(SelectCriteria selectCriteria) {

        List<AdminEventDTO> adminNoticeList = mapper.selectOngoingEventList(selectCriteria);

        for (int i = 0; i < adminNoticeList.size(); i++){

            adminNoticeList.get(i).setEventTitle(adminNoticeList.get(i).getEventTitle().substring(0, 35));
        }

        return adminNoticeList;
    }

    // 종료된 이벤트 조회
    @Override
    public List<AdminEventDTO> selectFinshedEventList(SelectCriteria selectCriteria) {

        List<AdminEventDTO> finshedEventList = mapper.selectFinshedEventList(selectCriteria);

        for (int i = 0; i < finshedEventList.size(); i++){

            finshedEventList.get(i).setEventTitle(finshedEventList.get(i).getEventTitle().substring(0, 35));
        }
        return finshedEventList;
    }

    @Override
    public int selectTotalPage(Map<String, String> searchMap) {

        int result = mapper.selectTotalPage(searchMap);

        return result;
    }
}
