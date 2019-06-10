package com.iyoa.cleanaddis.security;

import java.util.Map.Entry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${enablesecurity}")
    private boolean globalSecurityEnabled;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String UUID = "{[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}}";
	private static final String NUM = "{[0-9]+}";
	private static final String ALPHA = "{[A-z]+}";
	private static final String ALPHANUMERIC = "{[A-z0-9 &]}";
	private static final String SEFURL = "{[A-z0-9-]+}";

    public SecurityConfig() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    /**
     * This method should determine any paths can ignore authentication
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

        if (!globalSecurityEnabled) {
            disableSecurity(web);
        }
        
        web.ignoring().antMatchers("/resources/**");
      
    }

    /**
     * Enable or disable security for all paths based on boolean set in application.properties
     * @param web
     * @throws Exception
     */

    public void disableSecurity(WebSecurity web) {
        web.ignoring().antMatchers("/**");
    }

    /**
     * This method will add all paths from the routeconfig to the security config
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {
    	 http.cors().and().csrf().disable().authorizeRequests()
    	 .antMatchers("/article/articles").permitAll()
         .antMatchers("/article/create").permitAll()
         .antMatchers("/category/create").permitAll()
         .antMatchers("/media/create").permitAll()
         .antMatchers("/user/changepasswordexternal").permitAll()
         .anyRequest().authenticated();
    }

}