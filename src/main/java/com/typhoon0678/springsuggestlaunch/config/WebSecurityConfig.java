package com.typhoon0678.springsuggestlaunch.config;

import com.typhoon0678.springsuggestlaunch.service.UserDetailService;
import com.typhoon0678.springsuggestlaunch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final UserDetailService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailService userDetailService) throws Exception {
        return http
                .authorizeHttpRequests((auth) ->
                        auth.requestMatchers(
                                        "/login",
                                        "/signup",
                                        "/user",
                                        "/",
                                        "/restaurants",
                                        "/css/**",
                                        "/js/**").permitAll()
                                .requestMatchers(toH2Console()).permitAll()
                                .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin((formLogin) ->
                        formLogin.loginPage("/login")
                                .defaultSuccessUrl("/restaurants"))
                .logout((logout) -> logout.logoutSuccessUrl("/login")
                        .invalidateHttpSession(true))
                .userDetailsService(userDetailService)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
