package com.ravi.assignment.qualibrate.configuration;

import static java.util.Arrays.asList;

import com.ravi.assignment.qualibrate.cors.QualibrateCorsConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${cros.origins}")
    private String allowedOrigins;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.cors().and();
    }

    @Bean(name = "corsConfigurationSource")
    CorsConfigurationSource corsConfigurationSource() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new QualibrateCorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedOrigins(asList(allowedOrigins.split(",")));
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
