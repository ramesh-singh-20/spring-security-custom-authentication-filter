package com.alphacoder.springsecuritycustomauthenticationfilter.config;

import com.alphacoder.springsecuritycustomauthenticationfilter.security.authentication.CustomAuthentication;
import com.alphacoder.springsecuritycustomauthenticationfilter.security.filter.CustomAuthenticationFilter;
import com.alphacoder.springsecuritycustomauthenticationfilter.security.provider.CustomAuthenticationProvider;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
@Configuration
public class UserConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationFilter filter;

    private final CustomAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(filter, BasicAuthenticationFilter.class);
        http.httpBasic();

        http.authorizeRequests().anyRequest().permitAll();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }




}
