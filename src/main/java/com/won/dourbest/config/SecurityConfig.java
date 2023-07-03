package com.won.dourbest.config;

import com.won.dourbest.user.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    private UserDetailServiceImpl userDetail;

    @Autowired //로그인을 위한 서비스 생성자 주입
    public SecurityConfig(UserDetailServiceImpl userDetail) {
        this.userDetail = userDetail;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public WebSecurityCustomizer configure(){
        return web -> web.ignoring().antMatchers("/css/**", "/js/**", "/lib/**","/images/**","templates/**");
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().anyRequest().permitAll();
//        return http.build();
//    }


    // 로그인 관련 설정

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
        http.formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .usernameParameter("username") //로그인시 사용할 파라미터
                .passwordParameter("password")
                .failureUrl("/user/longin/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher
                                    ("/user/logout"))
                .logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetail)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }


}
