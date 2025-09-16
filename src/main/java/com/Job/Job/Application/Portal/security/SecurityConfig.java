package com.Job.Job.Application.Portal.security;

import com.Job.Job.Application.Portal.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Autowired
  private UserDetailService userDetailService;
    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf(Customizer -> Customizer.disable());
      http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
              .httpBasic(Customizer.withDefaults())
              .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
      return http.build();
  }

@Bean
  public AuthenticationProvider authProvider()
  {
      DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
      provider.setUserDetailsService(userDetailService);
      provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
      return provider;
  }
}
