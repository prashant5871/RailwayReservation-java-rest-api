package com.project.railway.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.project.railway.dao.UserDao;
import com.project.railway.service.UserService;
import com.project.railway.service.UserServiceImpl;

@Configuration
public class RailwaySecurityConfig {
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(@Autowired HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.POST, "/user/register")
				.permitAll().requestMatchers(HttpMethod.GET, "/admin/trains").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/admin/trains/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/admin/search-train/*/*").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/admin/search-train/*/*").hasRole("USER")
				.requestMatchers(HttpMethod.POST,"/admin/station").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/admin/stations").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/admin/stations/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/admin/add-route/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/admin/get-route/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/admin/add-train").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT,"/admin/station/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/admin/remove-train/**").hasRole("ADMIN"));

		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable Cross Site Request Forgery (CSRF)
		// in general, not required for stateless REST APIs that use POST, PUT, DELETE
		// and/or PATCH
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

}
