//package com.pms.MovieBookingApp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .and()
//            .logout()
//            .and()
//            .csrf().disable();
//    }
//    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("admin").password("{noop}admin").roles("ADMIN")
//            .and()
//            .withUser("user").password("{noop}user").roles("USER");
//    }
//
//}
