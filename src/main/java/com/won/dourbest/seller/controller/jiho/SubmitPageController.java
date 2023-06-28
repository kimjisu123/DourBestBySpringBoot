package com.won.dourbest.seller.controller.jiho;

import com.won.dourbest.seller.dto.FundingDTO;
import com.won.dourbest.seller.dto.PlanDTO;
import com.won.dourbest.seller.service.jiho.SubmitService;
import com.won.dourbest.seller.service.jiho.SubmitServiceImpl;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/submit")
@Slf4j
public class SubmitPageController {

    private final SubmitService submitService;

    @Autowired
    public SubmitPageController(SubmitService submitService) {
        this.submitService = submitService;
    }

    @GetMapping()
    public String submitPage() {
        return "seller/funding/submitpage";
    }

    /* 요금제 옵션 값 불러오기 */
    @GetMapping("/plan")
    public String submitPlan(Model model) {

        List<PlanDTO> planList = submitService.allPlan();
        Map<Integer, List<String>> map = new HashMap<>();

        for(int i = 0; i < planList.size(); i++) {

            List<String> list = new ArrayList<>();
            String subtext = planList.get(i).getPlanContent();

            String[] strarr = subtext.split(",");
            for(int j = 0; j < strarr.length; j++) {
                list.add(strarr[j].trim());
            }
            map.put(i, list);
        }
        System.out.println(map.get(1).get(0));
        model.addAttribute("planList", planList);
        model.addAttribute("pmap", map);


        return "seller/funding/submitplan";
    }

    /* 목표 금액 입력 화면 */
    @GetMapping("/money")
    public String submitMoney(Model model, @RequestParam int code) {
        model.addAttribute("planCode", code);
        return "/seller/funding/submitmoney";
    }

    /* 펀딩 기본정보 입력 화면 */
    @PostMapping("/fundinfo")
    public String fundInfo(Model model, @RequestParam String inputMoney, @RequestParam int planCode) {

        System.out.println("inputmoney = " + inputMoney);
        System.out.println("hdplanCode = " + planCode);
        model.addAttribute("inputMoney", inputMoney);
        model.addAttribute("planCode", planCode);

        return "/seller/funding/submitfundinfo";
    }

    @PostMapping("/moreinfo")
    public String moreInfo(Model model, @RequestParam int planCode, @RequestParam String inputMoney
            , @RequestParam String fundTitle, @RequestParam("mainImg") MultipartFile mainImg
            , @RequestParam String searchTag, @RequestParam String startDate
            , @RequestParam String endDate, HttpServletRequest request) {

//        System.out.println("inputMoney = " + inputMoney);
//        System.out.println("planCode = " + planCode);
//        System.out.println("fundTitle = " + fundTitle);
//        System.out.println("mainImg = " + mainImg);
//        System.out.println("searchTag = " + searchTag);
//        System.out.println("startDate = " + startDate);
//        System.out.println("endDate = " + endDate);

        /* 파일 저장 경로 생성 */
        String root = "C:\\dev\\fundingImg";
        System.out.println("root = " + root);

        String mainFilePath = root + "\\mainImg";

        File mkdir = new File(mainFilePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        /* 랜덤 파일명 생성 */
        String originFileName = mainImg.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-","") + ext;

        try {
            mainImg.transferTo(new File(mainFilePath + "\\" + savedName));
            System.out.println("사진 저장 성공");
            System.out.println("savedName = " + savedName);
        } catch (IOException e) {
            /* 실패 시 사진 삭제 */
            new File(mainFilePath + "\\" + savedName).delete();
            System.out.println("사진 저장 실패");
        }

        /* 태그를 ,을 기준으로 자르기 */
        String tag = searchTag;
        String[] sarr = tag.split(",");
        int result = submitService.insertTag(sarr);

        if (result == 0) System.out.println("원래 있는 태그를 입력");
        else System.out.println("새로운 태그를 입력");



        model.addAttribute("planCode", planCode);
        model.addAttribute("inputMoney", inputMoney);
        model.addAttribute("fundTitle", fundTitle);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("originFileName", originFileName);
        model.addAttribute("savedFileName", savedName);

        return "/seller/funding/submitmoreinfo";
    }

    @PostMapping("/options")
    public String options(Model model, @RequestParam int planCode, @RequestParam String inputMoney
            , @RequestParam String fundTitle, @RequestParam String startDate
            , @RequestParam String endDate, @RequestParam String fundSummary
            , @RequestParam String fundContent, @RequestParam(required = false) String videoUrl
            , @RequestParam(required = false)MultipartFile topImg, @RequestParam String originFileName
            , @RequestParam String savedFileName, HttpServletRequest request) {

        System.out.println("originFileName = " + originFileName);
        System.out.println("savedFileName = " + savedFileName);


        return "seller/funding/submitoptions";
    }

}
