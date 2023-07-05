package com.won.dourbest.user.mypage.service;

import com.won.dourbest.common.dto.CategoryDTO;
import com.won.dourbest.user.mypage.repository.MypageCommonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageCommonServiceImpl implements MypageCommonService{

    private final MypageCommonMapper mypageCommonMapper;

    @Override
    public List<CategoryDTO> fundingCategory() {
        return mypageCommonMapper.fundingCategory();
    }
}
