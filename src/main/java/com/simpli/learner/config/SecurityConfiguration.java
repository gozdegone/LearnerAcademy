package com.simpli.learner.config;

import com.simpli.learner.service.AdminService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfiguration {

  private final CustomLoginSuccessHandler successHandler;

  private final AdminService adminService;

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
      throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    try {
      authProvider.setUserDetailsService(adminService);
      authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
      return authProvider;
    } catch (Exception e) {
      log.error("Exception on authenticationProvider: ", e);
      return null;
    }

  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        // URL matching for accessibility
        .antMatchers("/", "/login", "/register").permitAll()
        .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
        .antMatchers("/account/**").hasAnyAuthority("USER")
        .anyRequest().authenticated()
        .and()
        // form login
        .csrf().disable().formLogin()
        .loginPage("/login")
        .failureUrl("/login?error=true")
        .successHandler(successHandler)
        .usernameParameter("name")
        .passwordParameter("password")
        .and()
        // logout
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/")
        .and()
        .exceptionHandling()
        .accessDeniedPage("/access-denied");

    http.authenticationProvider(authenticationProvider());
    http.headers().frameOptions().sameOrigin();

    return http.build();
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
  }

}
