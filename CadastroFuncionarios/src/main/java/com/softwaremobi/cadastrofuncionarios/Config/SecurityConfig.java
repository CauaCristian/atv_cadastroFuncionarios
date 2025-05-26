package com.softwaremobi.cadastrofuncionarios.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.setSharedObject(SecurityContextRepository.class, new NullSecurityContextRepository());

        http
                .securityMatcher("/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()

                        // POST /passageiro exige autenticação
                        .requestMatchers(HttpMethod.POST, "/passageiro/**").authenticated()

                        // PUT/DELETE em /voo, /portao, /relatorio exige cargo ADMIN
                        .requestMatchers(HttpMethod.PUT, "/voo/**", "/portao/**", "/relatorio/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/voo/**", "/portao/**", "/relatorio/**").hasRole("ADMIN")

                        // Outras rotas POST (exceto /auth) exigem autenticação
                        .requestMatchers(HttpMethod.POST, "/**").authenticated()

                        // Demais requisições são públicas
                        .anyRequest().permitAll()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
