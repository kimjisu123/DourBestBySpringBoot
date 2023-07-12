package com.won.dourbest.main.controller;

import com.won.dourbest.admin.dto.EventDTO;
import com.won.dourbest.admin.dto.NoticeDTO;
import com.won.dourbest.main.model.service.NoticeEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dourbest")
public class NoticeEventController {

    private final NoticeEventService noticeEventService;

    public NoticeEventController(NoticeEventService noticeEventService) {
        this.noticeEventService = noticeEventService;
    }

    @GetMapping("/notice")
    public String notice() {

        return "customerService/customerService";
    }

    @GetMapping("/announcement")
    public String announcement(Model model) {

        List<NoticeDTO> noticeList = noticeEventService.selectNotice();
        List<EventDTO> eventList = noticeEventService.selectEvent();
        List<EventDTO> endEvent = noticeEventService.endEvent();

        System.out.println("noticeList = " + noticeList);
        System.out.println("endEvent = " + endEvent);

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("eventList", eventList);
        model.addAttribute("endEvent", endEvent);

        return "main/noticeEvent";
    }

    @GetMapping("/announcement/{code}")
    public String announce(Model model, @PathVariable int code) {

        NoticeDTO notice = noticeEventService.detailNotice(code);

        model.addAttribute("notice", notice);

        return "main/noticeDetail";
    }


    @GetMapping("/event/{code}")
    public String event(Model model, @PathVariable int code) {

        EventDTO event = noticeEventService.detailEvent(code);

        model.addAttribute("event", event);

        return "main/eventDetail";
    }
}
