package pl.opole.uni.springWebApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/api/public/**").permitAll()
      .antMatchers("/api/admin/**").hasRole("ADMIN")
      .antMatchers("/api/user/**").hasRole("USER")
      //.anyRequest().authenticated()
      .anyRequest().permitAll()
      .and()
      //.formLogin()
      //.loginProcessingUrl("/api/auth/login")
      //.defaultSuccessUrl("/api/auth/success")
//      .and()
//      .logout()
//      .logoutUrl("/api/auth/logout")
//      .logoutSuccessUrl("/api/auth/logout-success")
//      .and()
      .csrf().disable();
  }
}

