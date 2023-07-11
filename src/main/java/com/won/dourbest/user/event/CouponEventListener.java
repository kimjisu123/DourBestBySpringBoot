package com.won.dourbest.user.event;

import com.won.dourbest.user.dao.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CouponEventListener {

    private final MemberMapper mapper;

    @EventListener
    public void couponEvent(RegistEvent event) {
        mapper.couponInsert(event.getMemberCode(),3);

    }
}
