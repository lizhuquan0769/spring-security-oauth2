package com.lzq.authorizationserver.config;

import com.lzq.authorizationserver.security.RbacUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by lizhuquan on 2018/7/5.
 */
@Configuration
@EnableWebSecurity
public class WebMvcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new RbacUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers();
        http.authorizeRequests()
                .anyRequest().permitAll();
        http.csrf().disable();
        http.httpBasic().disable();
        http.formLogin();
    }
}
