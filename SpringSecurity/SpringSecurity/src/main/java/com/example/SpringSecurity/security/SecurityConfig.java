package com.example.SpringSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}
	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		    .csrf(customizer->customizer.disable())
		    .authorizeHttpRequests(request->request.anyRequest().authenticated())
//		    .formLogin(Customizer.withDefaults())
		    .httpBasic(Customizer.withDefaults())
		    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		
		
		
		
		
		
		
		return http.build();		
	}
//	@Bean
//	public UserDetailsService userDetailsService() throws Exception {
//		
//		@SuppressWarnings("deprecation")
//		UserDetails user=User.withDefaultPasswordEncoder()
//				             .username("gopi")
//				             .password("gopi@123")
//				             .roles("USER")
//				             .build();
//		@SuppressWarnings("deprecation")
//		UserDetails admin=User.withDefaultPasswordEncoder()
//	             .username("gopi")
//	             .password("gopi@123")
//	             .roles("USER")
//	             .build();
//		
//		
//		return new InMemoryUserDetailsManager(user,admin);
//		
//	}
	
	


}
