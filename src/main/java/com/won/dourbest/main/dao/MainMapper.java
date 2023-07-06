package com.won.dourbest.main.dao;

import com.won.dourbest.user.dto.LikeFundingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

        List<LikeFundingDTO> getSlideImages();

        List<LikeFundingDTO> ToplikeFundings();

        List<LikeFundingDTO> OpenFundings();

        List<LikeFundingDTO> EndFundings();


}
