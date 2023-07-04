package com.won.dourbest.config;

import com.siot.IamportRestClient.IamportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public IamportClient client(){
       return new IamportClient("7526816782137126","fEkA4KEvTyRmGezJaob3MFV1WKTGCE4HIMZjWvd9niRctcOTtsUgawunwei8UFgp3xJfxaMymQczDONB");
    }

}