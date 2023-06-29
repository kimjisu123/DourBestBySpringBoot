package com.won.dourbest.user.service;

import com.won.dourbest.user.dao.MemberMapper;
import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForLocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {

//    private final Logger log = LoggerFactory.getLogger(this.getClass())
    private final MemberMapper mapper;

    // 의존성 주입
    public MemberServiceImpl(MemberMapper mapper) {
        this.mapper = mapper;

    }

    @Override
    @Transactional(rollbackFor = { Exception.class }) // 데이터를 여러번 이동 할 수 있게 해주는 어노테이션
    public int registMember(Map<String, Object> map) {
//            log.info("insertMember" + member);
//            log.info("insertAddress" + address);
             // 메퍼에서 데이터 베이스에 접속하여 로직 실행에 필요한 쿼리를 호출함.
            String memberId =null;
            System.out.println("map ====== " + map);
            int result = mapper.registMember(map);
            int result2 = mapper.registAddress(map);
//            String Id = mapper.selectMemberById(memberId);
//        System.out.println("Id = " + Id);

        if (result > 0 && result2 > 0) {
            return 1;
        } else {
            throw new IllegalStateException();
        }
    }


}
