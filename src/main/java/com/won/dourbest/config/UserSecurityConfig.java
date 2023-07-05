package com.won.dourbest.config;

import com.won.dourbest.admin.account.service.AdminService;
import com.won.dourbest.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
@Order(2)
public class UserSecurityConfig {

    private final MemberService memberService;

    private final BCryptPasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(memberService);
        return provider;
    }


    @Bean
    public SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authenticationProvider(userAuthenticationProvider())
                .authorizeRequests()
                .antMatchers("/mypage/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/submit/**").hasRole("SELLER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                //  .defaultSuccessUrl("/")
                .successForwardUrl("/")
                //  .failureForwardUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .deleteCookies("JSESSIONID")  // 쿠키 제거
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .and().build();

    }
//
//    //사용자 인증
//    @Bean
//    public AuthenticationManager userAuthManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(memberService)
//                .passwordEncoder(passwordEncoder)
//                .and().build();
//    }


}