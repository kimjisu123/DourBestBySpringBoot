package com.won.dourbest.user.service;

import com.won.dourbest.common.exception.user.EmailNotFoundException;
import com.won.dourbest.user.dao.MemberMapper;
import com.won.dourbest.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForLocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MemberMapper mapper;

    // 회원가입 정보를  오라클에 저장 메소드
    @Override
    @Transactional(rollbackFor = { Exception.class }) // 데이터를 여러번 이동 할 수 있게 해주는 어노테이션
    public int registMember(Map<String, Object> map) {
//
        // 메퍼에서 데이터 베이스에 접속하여 로직 실행에 필요한 쿼리를 호출함.
        System.out.println("map ====== " + map);
        int result = mapper.registMember(map);
        int result2 = mapper.registAddress(map);

        // 권한 부여
        int auth = mapper.insertMemberAuth();

        if (result > 0 && result2 > 0 && auth > 0) {
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



    @Override
    public Optional<MemberDTO> findUser(String userId) {

        return mapper.findByMember(userId);

    }
    



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //예외 추가해주기
        MemberDTO member = mapper.findByMember(username).orElseThrow();
        //권한리스트
        List<MemberAuthListDTO> memberAuthList = member.getMemberAuthList();
        List<GrantedAuthority> authorities = new ArrayList<>();

        memberAuthList.forEach(list -> authorities.add(new SimpleGrantedAuthority(list.getMemberAuth().getMemberAuthName())));
        MemberImpl user = new MemberImpl(member.getMemberId(),member.getMemberPwd(),authorities);

        user.setDetail(member);
        log.info("member={}", user.getPassword());
        return user;
    }

    //회원 정보 수정
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int updateMember(Map<String, Object> map) {

        System.out.println("map = " + map);

        int result = mapper.updateMember(map);  // 매퍼로 수정
        int result2 = mapper.updateAddress(map);

        //업데이트는 리턴 받을 값이 없음(그래서 int 리턴)

        if (result > 0 && result2 > 0) {
            return 1;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public int changePwd(MemberDTO member) {

        int result = mapper.changePwd(member);

        if (result > 0) {
            return 1;
        } else {
            throw new IllegalStateException();
        }
    }
}