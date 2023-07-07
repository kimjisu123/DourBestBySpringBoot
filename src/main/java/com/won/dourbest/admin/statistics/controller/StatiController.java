package com.won.dourbest.admin.statistics.controller;

import com.won.dourbest.admin.common.Pagenation;
import com.won.dourbest.admin.common.SelectCriteria;
import com.won.dourbest.admin.statistics.dto.StatiDTO;
import com.won.dourbest.admin.statistics.service.StatiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class StatiController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final StatiServiceImpl statiServiceImpl;

    public StatiController(StatiServiceImpl statiServiceImpl) {

        this.statiServiceImpl = statiServiceImpl;
    }


    // 총 금액 순으로 조회
    @GetMapping("allPrice")
    public ModelAndView allPrice(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = statiServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<StatiDTO> statiAllPriceList = statiServiceImpl.selectAllPrice(selectCriteria);

        mv.setViewName("admin/statistics/allPrice");
        mv.addObject("statiAllPriceList", statiAllPriceList);
        mv.addObject("selectCriteria", selectCriteria);
        return mv;
    }

    // 총 조회수 순으로 조회
    @GetMapping("allViews")
    public ModelAndView allViews(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = statiServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<StatiDTO> statiAllViewsList = statiServiceImpl.selectAllViews(selectCriteria);

        mv.setViewName("admin/statistics/allInquiry");
        mv.addObject("statiAllViewsList", statiAllViewsList);
        mv.addObject("selectCriteria", selectCriteria);
        return mv;

    }

    // 총 좋아요 순으로 조회
    @GetMapping("allLikes")
    public ModelAndView allLikes(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = statiServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<StatiDTO> statiallLikesList = statiServiceImpl.selectAllLikes(selectCriteria);

        mv.setViewName("admin/statistics/allGood");
        mv.addObject("statiallLikesList", statiallLikesList);
        mv.addObject("selectCriteria", selectCriteria);
        return mv;

    }

    // 월 기준 금액순으로 조회
    @GetMapping("monthPrice")
    public ModelAndView monthPrice(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = statiServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<StatiDTO> statiMonthPriceList = statiServiceImpl.selectMonthPrice(selectCriteria);

        mv.setViewName("admin/statistics/monthPrice");
        mv.addObject("statiMonthPriceList", statiMonthPriceList);
        mv.addObject("selectCriteria", selectCriteria);
        return mv;
    }

    // 월 기준 조회수 순으로 조회
    @GetMapping("monthViews")
    public ModelAndView monthViews(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = statiServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<StatiDTO> statiMonthViewsList = statiServiceImpl.selectMonthViews(selectCriteria);

        mv.setViewName("admin/statistics/monthInquiry");
        mv.addObject("statiMonthViewsList", statiMonthViewsList);
        mv.addObject("selectCriteria", selectCriteria);
        return mv;

    }

    // 월 기준 좋아요 순으로 조회
    @GetMapping("monthLikes")
    public ModelAndView monthLikes(ModelAndView mv, @RequestParam(required = false) String searchId, @RequestParam(defaultValue = "1", value="currentPage") int pageNO){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchId", searchId);

        // 조건이 있을시에 보여지는 페이지의 갯수
        int totalPage = statiServiceImpl.selectTotalPage(searchMap);

        // 한 페이지에 보여줄 게시물 수
        int limit = 8;

        // 한번에 보여줄 페이징 버튼 수
        int button = 5;

        SelectCriteria selectCriteria = null;

        if(searchId != "" && searchId != null){
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button,searchId);  // 조건이 있을 경우
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNO, totalPage, limit, button);           // 조건이 없을 경우
        }


        List<StatiDTO> statiMonthLikesList = statiServiceImpl.selectMonthLikes(selectCriteria);

        mv.setViewName("admin/statistics/monthGood");
        mv.addObject("statiMonthLikesList", statiMonthLikesList);
        mv.addObject("selectCriteria", selectCriteria);
        return mv;

    }

}
