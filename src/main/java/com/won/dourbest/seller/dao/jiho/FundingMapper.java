package com.won.dourbest.seller.dao.jiho;

import com.won.dourbest.seller.dto.FundPageDTO;
import com.won.dourbest.seller.dto.MainImgDTO;
import com.won.dourbest.seller.dto.OptionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface FundingMapper {

    FundPageDTO selectFunding(int code);

    List<String> selectTag(int code);

    List<OptionDTO> selectOption(int code);

    String selectFile(int code);

    List<MainImgDTO> topFive(int code, int categoryCode);

    int categoryCode(int code);

    String selectId(int code);

    int addLikes(int fundingCode, int memberCode);

    int deleteLikes(int fundingCode, int memberCode);

    int selectLikes(int code, int memberCode);

    int insertReport(Map<String, Object> map);

    Integer selectCategory(String category);

    int selectReport(int code, int memberCode);

    String selectProfile(int memberCode);

    int selectSellerCode(int code);

    int selectMemberCode(int sellerCode);

    int selectStatus(int code);

    String selectRefund(int code);

    Date startDate(int code);

    Date endDate(int code);

    String email(int code);


//    int findCode(String name);
}
