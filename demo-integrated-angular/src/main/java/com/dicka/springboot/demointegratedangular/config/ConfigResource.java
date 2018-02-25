package com.dicka.springboot.demointegratedangular.config;

import com.dicka.springboot.demointegratedangular.secure.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableResourceServer
@Configuration
public class ConfigResource extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint entryPoint;

    @Override
    public void configure(HttpSecurity security) throws Exception{

        security
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                .csrf()
                .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .authorizeRequests()
                .antMatchers("/hallo").permitAll()
                .anyRequest().authenticated();
    }


}
