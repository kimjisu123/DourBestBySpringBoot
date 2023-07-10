package com.won.dourbest.admin.notice.controller;


import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.notice.dto.AdminNoticeDTO;
import com.won.dourbest.admin.notice.dto.AdminEventDTO;
import com.won.dourbest.admin.notice.service.NoticeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ModelAndView notice(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = noticeServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }




        List<AdminNoticeDTO> adminNoticeList = noticeServiceImpl.selectNoticeList(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("adminNoticeList", adminNoticeList);
        mv.setViewName("admin/notice/notice");

        log.info("adminNoticeList : " + adminNoticeList);
        return mv;
    }

    @GetMapping("/ongoingEvent")
    public ModelAndView ongoingEvent(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = noticeServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }




        List<AdminEventDTO> ongoingEventList = noticeServiceImpl.selectOngoingEventList(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("ongoingEventList", ongoingEventList);
        mv.setViewName("admin/notice/ongoingEvent");

        return mv;
    }

    @GetMapping("/finshedEvent")
    public ModelAndView finshedEvent(ModelAndView mv, @RequestParam(required = false) String searchValue, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = noticeServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchValue != "" && searchValue != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchValue);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }



        List<AdminEventDTO> finshedEventList = noticeServiceImpl.selectFinshedEventList(selectCriteria);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("finshedEventList", finshedEventList);
        mv.setViewName("admin/notice/finishedEvent");

        return mv;

    }

    @PostMapping("registEventNotice")
    @ResponseBody
    public String noticeEvent(){



        return
    }
}
