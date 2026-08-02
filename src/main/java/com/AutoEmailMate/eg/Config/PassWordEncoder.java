package com.AutoEmailMate.eg.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PassWordEncoder {
    @Bean
    public BCryptPasswordEncoder encode(){
            return new BCryptPasswordEncoder();
    }
}
