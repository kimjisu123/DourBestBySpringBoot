package com.won.dourbest.main.service;


import com.won.dourbest.user.dto.LikeFundingDTO;

import java.util.List;

public interface MainService {

    List<LikeFundingDTO> getSlideImages();

    List<LikeFundingDTO> ToplikeFundings();

    List<LikeFundingDTO> OpenFundings();

    List<LikeFundingDTO> EndFundings();

}
