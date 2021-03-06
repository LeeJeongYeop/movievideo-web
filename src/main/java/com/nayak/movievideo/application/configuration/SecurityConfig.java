package com.nayak.movievideo.application.configuration;

import com.nayak.movievideo.application.handler.SignInFailureHandler;
import com.nayak.movievideo.application.handler.SingInSuccessHandler;
import com.nayak.movievideo.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/javascript/**", "/css/**", "/lib/**").permitAll()
                .antMatchers("/user/sign-in", "/user/sign-up").permitAll();

        http.formLogin()
                .loginPage("/user/sign-in")
                .loginProcessingUrl("/user/sign-in")
                .usernameParameter("userId")
                .passwordParameter("userPassword")
                .failureHandler(new SignInFailureHandler())
                .successHandler(new SingInSuccessHandler("/"));

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
