package com.won.dourbest.user.service;

import com.won.dourbest.user.dao.MemberMapper;
import com.won.dourbest.user.dto.AddressDTO;
import com.won.dourbest.user.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForLocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MemberMapper mapper;
    private final PasswordEncoder passwordEncoder;

    // 의존성 주입
    public MemberServiceImpl(MemberMapper mapper,PasswordEncoder PasswordEncoder) {
        this.mapper = mapper;
        this.passwordEncoder = PasswordEncoder;

    }

    // 회원가입 정보를  오라클에 저장 메소드
    @Override
    @Transactional(rollbackFor = { Exception.class }) // 데이터를 여러번 이동 할 수 있게 해주는 어노테이션
    public int registMember(Map<String, Object> map) {
//
        // 메퍼에서 데이터 베이스에 접속하여 로직 실행에 필요한 쿼리를 호출함.
            System.out.println("map ====== " + map);
            int result = mapper.registMember(map);
            int result2 = mapper.registAddress(map);


        if (result > 0 && result2 > 0) {
            return 1;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean idCheck(String memberId) {

        return mapper.idCheck(memberId) > 0? true: false;
    }

    @Override
    public boolean emailCheck(String memberEmail) {

        return mapper.emailCheck(memberEmail) > 0? true : false; // 중복값이 있으면 1로 true를 리턴 없으면 0으로 false를 반환
    }
}
