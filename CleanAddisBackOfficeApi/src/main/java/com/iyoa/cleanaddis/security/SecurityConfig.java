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
        web.ignoring().antMatchers("/robots.txt");
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/countries");
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/regions");
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/countriesbyregion/" + ALPHA);
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/devices/" + NUM);
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/devices/region/" + ALPHA);
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/mobileos/");
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/mobileos/region/" + ALPHA);
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/desktopbrowsers/global");
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/desktopbrowsers/global/" + NUM);
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/top/desktopbrowsers/region/" + ALPHA);
        web.ignoring().antMatchers(HttpMethod.GET, "/testadvisor/deviceranking/" + ALPHANUMERIC + "/" + ALPHANUMERIC);
        
        web.ignoring().antMatchers(HttpMethod.GET, "/article/" + UUID);
        web.ignoring().antMatchers(HttpMethod.GET, "/article/get-related/" + SEFURL);
        web.ignoring().antMatchers(HttpMethod.GET, "/article/get-article-by-uuid/" + UUID);
        web.ignoring().antMatchers(HttpMethod.GET, "/article/get-article/" + SEFURL);
        web.ignoring().antMatchers(HttpMethod.GET, "/article/get-subcategories");
        web.ignoring().antMatchers(HttpMethod.GET, "/article/get-recent");
        web.ignoring().antMatchers(HttpMethod.GET, "/article/get-most-popular");
        web.ignoring().antMatchers(HttpMethod.GET, "/article/");
        web.ignoring().antMatchers(HttpMethod.GET, "/article/featured-articles");
        web.ignoring().antMatchers(HttpMethod.GET, "/category/");
        web.ignoring().antMatchers(HttpMethod.GET, "/filter/get-articles");
        web.ignoring().antMatchers(HttpMethod.POST, "/filter/get-filtered-articles");
        web.ignoring().antMatchers(HttpMethod.GET, "/impact-rating");

        web.ignoring().antMatchers(HttpMethod.GET, "/browsers/" + UUID);
        web.ignoring().antMatchers(HttpMethod.GET, "/browsers/");
        web.ignoring().antMatchers(HttpMethod.GET, "/browsers/brands/");
        web.ignoring().antMatchers(HttpMethod.GET, "/browsers/" + ALPHANUMERIC + "/versions");
        web.ignoring().antMatchers(HttpMethod.GET, "/browsers/" + ALPHANUMERIC + "/" + ALPHANUMERIC);
        web.ignoring().antMatchers(HttpMethod.GET, "/devices/" + UUID);
        web.ignoring().antMatchers(HttpMethod.GET, "/devices/");
        web.ignoring().antMatchers(HttpMethod.GET, "/devices/brands");
        web.ignoring().antMatchers(HttpMethod.GET, "/devices/" + ALPHANUMERIC + "/" + ALPHANUMERIC);

        web.ignoring().antMatchers(HttpMethod.POST, "/email");

        web.ignoring().antMatchers(HttpMethod.GET, "/signin");
        web.ignoring().antMatchers(HttpMethod.GET, "/login");
        web.ignoring().antMatchers(HttpMethod.GET, "/checkSession");

        web.ignoring().antMatchers(HttpMethod.GET, "/releaseadvisor/nextarticles/" + NUM);
        web.ignoring().antMatchers(HttpMethod.GET, "/releaseadvisor/next/" + NUM);
        web.ignoring().antMatchers(HttpMethod.GET, "/releaseadvisor/sefurls");
        web.ignoring().antMatchers(HttpMethod.GET, "/releaseadvisor/categories");
        
        web.ignoring().antMatchers(HttpMethod.GET, "/search/suggestion-tags");
        web.ignoring().antMatchers(HttpMethod.GET, "/search/get-articles-in-list");

        web.ignoring().antMatchers(HttpMethod.POST, "/article/create");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/changepasswordexternal");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/checktrial");
        web.ignoring().antMatchers(HttpMethod.GET, "/");

        web.ignoring().antMatchers(HttpMethod.GET, "/article/removelinks");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/is-user-exist");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/verify-reset-token");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/createpassword");
        web.ignoring().antMatchers(HttpMethod.PUT, "/user/reset-password");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/manualsubscribe/requestoffer");
        web.ignoring().antMatchers(HttpMethod.POST, "/user/manualsubscribe/requestofferdata");

        web.ignoring().antMatchers(HttpMethod.POST, "/newslettersubscribe");
        web.ignoring().antMatchers(HttpMethod.POST, "/trialregister");
        web.ignoring().antMatchers(HttpMethod.POST, "/trialregister/validate/email");
        web.ignoring().antMatchers(HttpMethod.POST, "/trialregister/validate/token");
        web.ignoring().antMatchers(HttpMethod.POST, "/trialregister/activate");
        
        web.ignoring().antMatchers(HttpMethod.GET, "/cloudadvisor/mobileoss"); // just for test logic. Later move to RoutesConfig
        web.ignoring().antMatchers(HttpMethod.GET, "/cloudadvisor/mobilebrowsers"); // just for test logic. Later move to RoutesConfig
        web.ignoring().antMatchers(HttpMethod.POST, "/cloudadvisor/addslot"); // just for test logic. Later move to RoutesConfig
        web.ignoring().antMatchers(HttpMethod.POST, "/cloudadvisor/slots"); // just for test logic. Later move to RoutesConfig
        web.ignoring().antMatchers(HttpMethod.POST, "/cloudadvisor/maxslots"); // just for test logic. Later move to RoutesConfig        
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
         .antMatchers("/article/create").permitAll()
         .antMatchers("/user/changepasswordexternal").permitAll()
         .anyRequest().authenticated();
    }

}