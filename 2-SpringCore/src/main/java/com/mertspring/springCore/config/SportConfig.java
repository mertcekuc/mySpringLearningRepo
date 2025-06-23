package com.mertspring.springCore.config;

import com.mertspring.springCore.common.Coach;
import com.mertspring.springCore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
