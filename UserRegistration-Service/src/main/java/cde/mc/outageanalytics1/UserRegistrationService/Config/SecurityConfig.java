package cde.mc.outageanalytics1.UserRegistrationService.Config;

import cde.mc.outageanalytics1.UserRegistrationService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
      /* http.authorizeRequests().antMatchers("/secure/rest/users").permitAll().and()
                .authorizeRequests().antMatchers("/secure/admin").hasAnyRole("ADMIN","admin").anyRequest().authenticated().
                and().formLogin().permitAll();*/
        http.authorizeRequests()
        .antMatchers("/user").permitAll()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("user/users","user/users/{userName}").hasRole("USER")
        .anyRequest().authenticated().and().httpBasic()
        .and().logout();
        //http.addFilterBefore()
   }

    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }
}
