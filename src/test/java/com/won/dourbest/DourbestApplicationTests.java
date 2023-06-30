package com.won.dourbest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Long.toUnsignedString;

@Slf4j
@SpringBootTest
class DourbestApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void test(){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/mypage/seller-inquire")
                .queryParam("page", 1)
                .queryParamIfPresent("status", Optional.ofNullable("N"))
                .queryParamIfPresent("searchType", Optional.ofNullable("배송"))
                .build();

        log.info(uriComponents.toString());
                                                    //{@searchCriteria.makeQuery(page,cri.getStatus(),cri.getSearchType())}|"-->

    }

    @Test
    void uuidtest(){

        UUID uuid = UUID.randomUUID();
        System.out.println("uuid = " + uuid);
        String substring = uuid.toString().substring(1,18);
        System.out.println("substring = " + substring);


    }


}
