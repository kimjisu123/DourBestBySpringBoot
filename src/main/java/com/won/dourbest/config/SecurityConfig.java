package com.won.dourbest.config;

import com.won.dourbest.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
public class SecurityConfig {

    private final MemberService memberService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring().antMatchers("/static/**", "/css/**", "/js/**", "/lib/**", "/images/**", "/templates/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/mypage/**").hasRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/submit").hasRole("SELLER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/user/login")
                //  .defaultSuccessUrl("/")
                .successForwardUrl("/")
                //  .failureForwardUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .deleteCookies("JSESSIONID")  // 쿠키 제거
                .invalidateHttpSession(true)
                .and().build();

    }

    //사용자 인증
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(memberService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }


}