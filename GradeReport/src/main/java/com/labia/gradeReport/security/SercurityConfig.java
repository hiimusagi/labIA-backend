package com.labia.gradeReport.security;

import com.labia.gradeReport.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SercurityConfig {
    private final SecurityServices securityServices;
    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        try {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "index", "/css/*", "/js/*", "/login").permitAll()
                    .antMatchers("/api/**").hasAnyRole(UserRole.STUDENT.name(),UserRole.LECTURE.name())
                    .anyRequest()
                    .authenticated();

            http
                    .authenticationProvider(daoAuthenticationProvider());

            http
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/hello", true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                    .and()
                    .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.SECONDS.toSeconds(20))
                    .key("somethingverysecured")
                    .rememberMeParameter("remember-me")
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");
        } catch (Exception e) {
            System.out.println(e);
        }
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(securityServices.passwordEncoder());
        provider.setUserDetailsService(userService);
        System.out.println(securityServices.passwordEncoder().encode("password"));
        return provider;
    }

}
