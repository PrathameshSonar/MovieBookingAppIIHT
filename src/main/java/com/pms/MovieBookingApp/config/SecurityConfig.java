package com.pms.MovieBookingApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		System.out.print("Before NOrmal USer          ====================================");
		
		
		UserDetails normalUser = User				
				.withUsername("pms")
				.password("{bcrypt}" + passwordEncoder().encode("password"))
				.roles("NORMAL")
				.build();
		
		System.out.print(normalUser + "          ====================================");
		
		UserDetails adminUser = User
				.withUsername("admin")
				.password("{bcrypt}" + passwordEncoder().encode("password"))
//				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(adminUser, normalUser); 
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/movie/all").permitAll()
				.requestMatchers("/movie/search/{movieName}").permitAll()
				.requestMatchers("/user/*").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin();
		
		return httpSecurity.build();
		
	}
}
