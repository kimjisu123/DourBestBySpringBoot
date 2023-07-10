package com.won.dourbest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/fundingImg/**")
                .addResourceLocations("file:///c:/dev/fundingImg/fundContentImg/")
                .addResourceLocations("file:///c:/dev/fundingImg/mainImg/")
                .addResourceLocations("file:///c:/dev/fundingImg/topImg/")
                .addResourceLocations("file:///c:/dev/fundingImg/profile/")
                .addResourceLocations("file:///c:/dev/fundingImg/reviewImg/");


    }
}
