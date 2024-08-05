package com.rs.user_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedMethods("GET","POST", "PUT", "DELETE")
                        .allowedOrigins("*");
                //addMapping la duong dan cua backend , allowedOrigins la duong dan frontend , nghia la
                // khi nguoi dung o ben frontend gui yeu cau thi no chi co the lay du lieu ung voi cac duong dan trong addMapping ma thoi,
                // cac duong dan khac neu ko cau hinh thi ko the lay ra ma dung duoc
            }
        };

    }
}
