package com.sharath.productservice.productservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {

    @Bean
    public ModelMapper getMapperObj(){
        return new ModelMapper();
    }
}
