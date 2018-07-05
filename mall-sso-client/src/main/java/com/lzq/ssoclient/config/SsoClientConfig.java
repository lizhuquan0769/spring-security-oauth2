package com.lzq.ssoclient.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by lizhuquan on 2018/7/5.
 */
@Configuration
@EnableOAuth2Sso
public class SsoClientConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers();
        http.authorizeRequests()
                .antMatchers("/me").authenticated()
                .anyRequest().authenticated();
        http.csrf().disable();
        http.logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/");
    }
}
