package com.github.liquidjoo.placesearch.config;

import com.github.liquidjoo.placesearch.local.place.interceptor.KeywordInterceptor;
import com.github.liquidjoo.placesearch.user.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/user/**", "/login")
                .addPathPatterns("/search");

        registry.addInterceptor(new KeywordInterceptor())
                .addPathPatterns("/place/search");
    }
}
