package com.won.dourbest.seller.service.jiho;

import java.util.Map;

public interface FundingService {

    Map<String, Object> fundingPage(int code);

    int addLikes(int fundingCode, int memberCode);

    int deleteLikes(int fundingCode, int memberCode);

    int selectLikes(int code, int memberCode);
}
