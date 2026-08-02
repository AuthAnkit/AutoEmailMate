package com.AutoEmailMate.eg.Config;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable;

@Configuration
public class SecuriyConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                //.requestMatchers("/user/register").permitAll()
                        .anyRequest().permitAll()
        );
        return http.build();
    }
}
