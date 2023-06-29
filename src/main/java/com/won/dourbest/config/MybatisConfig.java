package com.won.dourbest.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.won.dourbest", annotationClass = Mapper.class)
public class MybatisConfig {

}