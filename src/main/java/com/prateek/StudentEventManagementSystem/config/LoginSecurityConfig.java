package com.prateek.StudentEventManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
      authenticationMgr.inMemoryAuthentication()
            .withUser("user").password("upassword").roles("USER")
            .and()
            .withUser("admin").password("apassword").roles("USER","ADMIN");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {


      http.httpBasic().and().authorizeRequests()
            .antMatchers("/students").hasAnyRole("ADMIN","USER")
            .antMatchers("/students/new").hasAnyRole("ADMIN","USER")
            .antMatchers("/students/edit/**").hasRole("ADMIN")
            .antMatchers("/students/update/**").hasRole("ADMIN")
            .antMatchers("/").permitAll()
            .and()
            .formLogin();

   }

   @Bean
   public PasswordEncoder getPasswordEncoder() {
      return NoOpPasswordEncoder.getInstance();
   }
}

