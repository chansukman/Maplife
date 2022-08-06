package com.cardiff.maplife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                // Pages with /user need users to be signed in with the role USER
                // Pages with /admin need users to be signed in with the role of ADMIN
                .mvcMatchers("/").hasRole("REGISTERED")
                .mvcMatchers("resource/**").permitAll() //
                .mvcMatchers("css/**").permitAll() //
                .mvcMatchers("img/**").permitAll() //
                .antMatchers("/resources/**").permitAll().anyRequest().permitAll()
                .and()
                .formLogin();
               /* .and()
                .logout().logoutSuccessUrl("/").permitAll(); */// Logout redirects to home page

    }

    //Don't encrypt password
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
