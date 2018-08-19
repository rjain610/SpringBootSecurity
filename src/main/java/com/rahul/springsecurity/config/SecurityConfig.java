package com.rahul.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().invalidSessionUrl("/invalid").maximumSessions(1).expiredUrl("/sessionExpired")
				.maxSessionsPreventsLogin(true).sessionRegistry(sessionRegistry());

		http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user")
				.password("password").roles("USER");

	}

	// Register HttpSessionEventPublisher
	@Bean
	public static ServletListenerRegistrationBean httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
	}

	// Work around https://jira.spring.io/browse/SEC-2855
	@Bean
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}
}
