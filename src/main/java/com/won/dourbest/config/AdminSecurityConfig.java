package com.won.dourbest.config;

import com.won.dourbest.admin.account.service.AdminService;
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
@Order(1)
public class AdminSecurityConfig {

    private final AdminService adminService;

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


    @Bean
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authenticationProvider(adminAuthenticationProvider())
//                .antMatcher("/admin/**")   // 이거만 추가했음
                .authorizeRequests()
//                .antMatchers("/admin/adminAccount").hasRole("SUPER")
//                .antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('SUPER')")
                .anyRequest().permitAll()
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