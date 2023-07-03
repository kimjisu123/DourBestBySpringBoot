package com.won.dourbest.user.service;

import com.won.dourbest.user.dao.MemberMapper;
import com.won.dourbest.user.dto.MemberDTO;
import com.won.dourbest.user.dto.MemberDetail;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//
//@Service
//public class UserDetailServiceImpl implements UserDetailService {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//    private final MemberMapper mapper;
//    public UserDetailServiceImpl(MemberMapper mapper) {
//        this.mapper = mapper;
//    }
//
//    /* 사용자가 입력한 아이디를 토대로 해당 회원 조회한 후 UserDetails 객체 타입의 User객체를 만들어서 반환하는 메소드
////     * */
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////        log.info("[AuthenticationService] =====================================================");
////        log.info("[AuthenticationService] memberId : " + username);
////        MemberDetail member = mapper.findByMemberId(username);
////        log.info("[AuthenticationService] member : " + member);
////
////        if (member == null) {
////            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
////        }
////
////
////        return member;
//
//    }

//}
