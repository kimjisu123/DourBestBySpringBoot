package com.won.dourbest.admin.notice.controller;


import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;
import com.won.dourbest.admin.notice.service.NoticeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class NoticeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final NoticeServiceImpl noticeServiceImpl;
    public NoticeController(NoticeServiceImpl noticeServiceImpl) {
        this.noticeServiceImpl = noticeServiceImpl;
    }

    // 공지사항 조회
    @GetMapping("/notice")
    public ModelAndView notice(ModelAndView mv){

        List<AdminNoticeDTO> adminNoticeList = noticeServiceImpl.selectNoticeList();

        mv.addObject("adminNoticeList", adminNoticeList);
        mv.setViewName("admin/notice/notice");

        log.info("adminNoticeList : " + adminNoticeList);
        return mv;
    }

    @GetMapping("/ongoingEvent")
    public ModelAndView ongoingEvent(ModelAndView mv){

        List<AdminEventDTO> ongoingEventList = noticeServiceImpl.selectOngoingEventList();

        mv.addObject("ongoingEventList", ongoingEventList);
        mv.setViewName("admin/notice/ongoingEvent");

        return mv;
    }

    @GetMapping("/finshedEvent")
    public ModelAndView finshedEvent(ModelAndView mv){

        List<AdminEventDTO> finshedEventList = noticeServiceImpl.selectFinshedEventList();

        mv.addObject("finshedEventList", finshedEventList);
        mv.setViewName("admin/notice/finishedEvent");

        return mv;

    }
}
