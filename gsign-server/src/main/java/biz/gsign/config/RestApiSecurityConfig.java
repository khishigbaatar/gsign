package biz.gsign.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Order(0)
public class RestApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .logout()
                .logoutSuccessUrl("/#/logout");
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .mvcMatchers("/loginProcessing").permitAll()
                .mvcMatchers("/loginError").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic().disable()
                .csrf().disable()
                .exceptionHandling();
    }

}
