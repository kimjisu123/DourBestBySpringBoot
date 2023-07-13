package com.won.dourbest.seller.service.jiho;

import java.util.Map;

public interface BeforeFundingService {
    Map<String, Object> getImg();

    int searchAuth(int memberCode);
}
