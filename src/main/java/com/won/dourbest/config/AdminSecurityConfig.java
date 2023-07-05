package com.won.dourbest.config;

import com.won.dourbest.admin.account.service.AdminService;
import com.won.dourbest.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AdminSecurityConfig {

    private final AdminService adminService;
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
    public DaoAuthenticationProvider adminAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(adminService);
        return provider;
    }
//    @Bean
//    public DaoAuthenticationProvider userAuthenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(memberService);
//        return provider;
//    }

    @Order(2)
    @Bean
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authenticationProvider(adminAuthenticationProvider())
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('SUPER')")
                .antMatchers("/admin/adminAccount").hasRole("SUPER")
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/admin/login")
                //  .defaultSuccessUrl("/")
                .successForwardUrl("/")
                //  .failureForwardUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                .deleteCookies("JSESSIONID")  // 쿠키 제거
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .and().build();

    }




//    @Bean
//    @Primary
//    public AuthenticationManager adminAuthManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(adminService)
//                .passwordEncoder(passwordEncoder())
//                .and().build();
//    }


}