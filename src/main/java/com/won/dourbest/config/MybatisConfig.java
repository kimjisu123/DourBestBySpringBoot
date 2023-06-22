package com.won.dourbest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.won.dourbest")
public class MybatisConfig {
}
