package com.won.dourbest.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Getter
@Setter
@ToString
public class SearchCriteria extends Criteria{

    private String searchType;
    private String status;
    private String order;

    public String makeQuery(Integer page) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParamIfPresent("status", Optional.ofNullable(status))
                .queryParamIfPresent("searchType", Optional.ofNullable(searchType))
                .queryParamIfPresent("order", Optional.ofNullable(order))
                .encode()
                .build()
                .toUriString();
    }
}
