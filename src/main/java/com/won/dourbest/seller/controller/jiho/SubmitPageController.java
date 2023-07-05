package com.won.dourbest.seller.controller.jiho;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.seller.dto.FundingDTO;
import com.won.dourbest.seller.dto.FundingOptionDTO;
import com.won.dourbest.seller.dto.PlanDTO;
import com.won.dourbest.seller.service.jiho.SubmitService;
import com.won.dourbest.seller.service.jiho.SubmitServiceImpl;
import groovy.util.logging.Slf4j;
import jdk.jfr.ContentType;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @GetMapping("/category")
    public String submitCategoty(Model model) {

        List<CategoryDTO> categoryList = submitService.getFundCategory();
        System.out.println("categoryList = " + categoryList);

        model.addAttribute("categoryList", categoryList);

        return "seller/funding/submitcategory";
    }

    /* 요금제 옵션 값 불러오기 */
    @GetMapping("/plan")
    public String submitPlan(Model model, @RequestParam int categoryCode) {

        System.out.println("categoryCode = " + categoryCode);

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
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("planList", planList);
        model.addAttribute("pmap", map);


        return "seller/funding/submitplan";
    }

    /* 목표 금액 입력 화면 */
    @GetMapping("/money")
    public String submitMoney(Model model, @RequestParam int categoryCode, @RequestParam int code) {
        System.out.println("categoryCode = " + categoryCode);

        model.addAttribute("planCode", code);
        model.addAttribute("categoryCode", categoryCode);
        return "/seller/funding/submitmoney";
    }

    /* 펀딩 기본정보 입력 화면 */
    @PostMapping("/fundinfo")
    public String fundInfo(Model model, @RequestParam int categoryCode, @RequestParam String inputMoney, @RequestParam int planCode) {

        System.out.println("inputmoney = " + inputMoney);
        System.out.println("hdplanCode = " + planCode);
        model.addAttribute("inputMoney", inputMoney);
        model.addAttribute("planCode", planCode);
        model.addAttribute("categoryCode", categoryCode);

        return "/seller/funding/submitfundinfo";
    }

    @PostMapping("/moreinfo")
    public String moreInfo(Model model, @RequestParam int categoryCode, @RequestParam int planCode, @RequestParam String inputMoney
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
        String root = "C:\\dev\\fundingImg\\";
        System.out.println("root = " + root);

        String mainFilePath = root + "mainImg";

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
        model.addAttribute("categoryCode", categoryCode);

        return "/seller/funding/submitmoreinfo";
    }

    @PostMapping("/options")
    public String options(Model model, @RequestParam int categoryCode, @RequestParam int planCode, @RequestParam String inputMoney
            , @RequestParam String fundTitle, @RequestParam String startDate
            , @RequestParam String endDate, @RequestParam String fundSummary
            , @RequestParam String fundContent, @RequestParam(required = false) String videoUrl
            , @RequestParam(required = false)MultipartFile topImg, @RequestParam String originFileName
            , @RequestParam String savedFileName, @RequestParam String oriName
            , @RequestParam String saveName, HttpServletRequest request) throws ParseException {

        System.out.println("originFileName = " + originFileName);
        System.out.println("savedFileName = " + savedFileName);
        System.out.println("fundContent = " + fundContent);

        /* 펀딩 상단 사진 저장 */
        String root = "C:\\dev\\fundingImg\\";
        String topPath = root + "topImg";

        File mkdir = new File(topPath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        /* 랜덤 파일명 생성 */
        String originName = topImg.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-","") + ext;

        try {
            topImg.transferTo(new File(topPath + "\\" + savedName));
        } catch (IOException e) {
            new File(topPath + "\\" + savedName).delete();
            throw new RuntimeException(e);
        }

        /* inputMoney는 int로 설정해서 , 뺴는 작업 */
        int goalmoney = Integer.parseInt(inputMoney.replace(",", ""));

        /* Sting으로 되어있는 startDate, endDate Date형식으로 바꾸기 */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

        Date startdate = dateFormat.parse(startDate);
        Date enddate = dateFormat.parse(endDate);

        System.out.println("startdate = " + startdate);
        System.out.println("enddate = " + enddate);

        /* 맵 객체의 값 담기 */
        Map<String, Object> tossMap = new HashMap<>();
        tossMap.put("fundTitle", fundTitle);
        tossMap.put("fundSummary", fundSummary);
        tossMap.put("fundContent", fundContent);
        tossMap.put("startDate", startdate);
        tossMap.put("endDate", enddate);
        tossMap.put("planCode", planCode);
        tossMap.put("goalMoney", goalmoney);
        tossMap.put("categoryCode", categoryCode);
        tossMap.put("planCode", planCode);
        tossMap.put("topVideoUrl", videoUrl);
        tossMap.put("topPhotoOrigin", originName); // 펀딩 화면 상단 사진
        tossMap.put("topPhotoSaved", savedName);
        tossMap.put("mainPhotoOrigin", originFileName); // 펀딩 메인 사진
        tossMap.put("mainPhotoSaved", savedFileName);
        tossMap.put("fundContentPhotoOrigin", oriName); // 펀딩 본문사진
        tossMap.put("fundContentPhotoSaved", saveName);

        Map<String, Integer> result = submitService.insertAboutFunding(tossMap);
        if((Integer) result.get("result") == 1) {
            System.out.println("펀딩 Insert 성공");
        } else {
            System.out.println("펀딩 Insert 실패");
        }
        model.addAttribute("currentKey", result.get("currentKey"));
        return "seller/funding/submitoptions";
    }

    @PostMapping(value="/summernoteImg", produces = "application/json")
    @ResponseBody
    public Map<String, String> previewImg(@RequestParam("file")MultipartFile file) {

        Map<String, String> returnMap = new HashMap<>();

        String root = "c:\\dev\\fundingImg\\";
        String contentImgPath = root + "fundContentImg";

        File mkdir = new File(contentImgPath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        String originName = file.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));

        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("savedName = " + savedName);
        File targetFile = new File(contentImgPath + "\\" + savedName);

        returnMap.put("originName", originName);
        returnMap.put("savedName", savedName);

        System.out.println("targetFile = " + targetFile);
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);  // 파일 저장
            returnMap.put("url", "/fundingImg/" + savedName);
            returnMap.put("responseCode", "success");
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);      // 저장된 파일 삭제
            e.printStackTrace();
        }

        System.out.println("returnMap = " + returnMap);
        return returnMap;
    }

    @GetMapping("/options")
    public String option() {
        return "seller/funding/submitoptions";
    }

    @PostMapping(value = "/option")
    @ResponseBody
    public String submitoption(@RequestBody FundingOptionDTO option) {
        System.out.println(option);

        String resultMessage = "";
        int result = submitService.insertOption(option);
        if(result == 1) {
            resultMessage = "success";
            System.out.println("성공");
        } else {
            System.out.println("실패");
            resultMessage = "fail";
        }

        return resultMessage;
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteOption(@RequestBody Map<String, String> map) {

        System.out.println("map = " + map);

        String message = "";
        int result = submitService.deleteOption(map);
        if(result == 1) {
            message = "성공";
        } else {
            message = "실패";
        }

        return message;
    }

    @GetMapping("/seller")
    public String sellerInfo(Model model, @RequestParam String fundingCode) {

        model.addAttribute("fundingCode", fundingCode);

        return "seller/funding/submitsellerinfo";
    }

    @PostMapping("/refund")
    public String refundRule(Model model, @RequestParam String bankName, @RequestParam String accountNum
                            , @RequestParam(required = false) String kakaoUrl
                            , @RequestParam(required = false) String homepageUrl
                            , @RequestParam(required = false) String snsUrl, @RequestParam String fundingCode) {

        System.out.println("bankName = " + bankName);
        Map<String, Object> map = new HashMap<>();
        map.put("accountNum", accountNum);
        map.put("bankName", bankName);
        map.put("kakaoUrl", kakaoUrl);
        map.put("homepageUrl", homepageUrl);
        map.put("snsUrl", snsUrl);

        int result = submitService.updateSeller(map);

        model.addAttribute("fundingCode", Integer.valueOf(fundingCode));


        return "seller/funding/submitrefund";
    }

    @PostMapping("/success")
    public String success(@RequestParam int fundingCode, @RequestParam String refundRule) {

        Map<String, Object> map = new HashMap<>();
        map.put("fundingCode", fundingCode);
        map.put("refundRule", refundRule);

        int result = submitService.updateFunding(map);

        return result > 0? "성공" : "실패";
    }
}
