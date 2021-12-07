package de.reichi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public static final String USER = "USER";
  public static final String ADMIN = "ADMIN";

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/greetings*").hasRole(USER)
      .antMatchers("/hello/search").hasRole(ADMIN)
      .and()
      .formLogin(); //TODO: switch formlogin to something else
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
    builder.inMemoryAuthentication()
      .withUser("reichi").password("{noop}123456").roles(USER)
      .and()
      .withUser("cgi").password("{noop}cgi").roles(USER, ADMIN)
      .and()
      .withUser("dat").password("{noop}dat").roles(USER, ADMIN)
      .and()
      .withUser("tim").password("{noop}tim").roles(USER, ADMIN)
      .and()
      .withUser("ranjith").password("{noop}ranjith").roles(USER, ADMIN);
  }
}
