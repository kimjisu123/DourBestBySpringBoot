package com.won.dourbest.user.mypage.repository;

import com.won.dourbest.common.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageCommonMapper {

    List<CategoryDTO> fundingCategory();


}
