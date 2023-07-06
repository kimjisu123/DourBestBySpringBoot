package com.won.dourbest.main.service;


import com.won.dourbest.main.dao.MainMapper;

import com.won.dourbest.user.dto.LikeFundingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService{

//        private final Logger log = LoggerFactory.getLogger(this.getClass());
        private final MainMapper mainMapper;

    public MainServiceImpl(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    @Override
    public List<LikeFundingDTO> getSlideImages() {


        return mainMapper.getSlideImages();
    }

    @Override
    public List<LikeFundingDTO> ToplikeFundings() {
        return mainMapper.ToplikeFundings();
    }

    @Override
    public List<LikeFundingDTO> OpenFundings() {
        return mainMapper.OpenFundings();
    }

    @Override
    public List<LikeFundingDTO> EndFundings() {
        return mainMapper.EndFundings();
    }


}
