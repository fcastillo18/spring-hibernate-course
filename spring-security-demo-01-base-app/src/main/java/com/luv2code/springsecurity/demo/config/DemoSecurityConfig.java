package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//				.anyRequest().authenticated()
//			.and()
//			.formLogin()
//				.loginPage("/showMyLoginPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//			.and()
//				.logout()
//				.permitAll();
//	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()  // allow public access to home page
            //allow access to that page  and all sub directoryjust to the role especified
            .antMatchers("/employees").hasRole("EMPLOYEE") 
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .antMatchers("/systems/**").hasRole("ADMIN")
            .and()
            .formLogin()
	            .loginPage("/showMyLoginPage")
	            .loginProcessingUrl("/authenticateTheUser")
	            .permitAll()
            .and()
	            .logout()
	            .logoutSuccessUrl("/")  // after logout then redirect to landing page (root)
	            .permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/access-denied"); 
    }
	
	
}
