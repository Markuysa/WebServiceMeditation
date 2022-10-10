package com.example.meditationbackend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MVConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/ ");
        viewResolver.setSuffix(".html");
        registry.viewResolver(viewResolver);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").
                addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:ext-resources/")
                .setCachePeriod(0);
        registry.addResourceHandler("/icons/**")
                .addResourceLocations("file:ext-resources/")
                .setCachePeriod(0);
        registry.addResourceHandler("/css/**").
                addResourceLocations("classpath:/static/css/");
    }
}
