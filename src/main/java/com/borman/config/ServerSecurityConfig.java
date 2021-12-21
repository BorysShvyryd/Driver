package com.borman.config;

import com.borman.exception.CustomAccessDeniedHandler;
import com.borman.exception.CustomAuthenticationEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    private final UserDetailsService userDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
////                .antMatchers("/register/**", "/login/**", "/").not().fullyAuthenticated()
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/drive/**").hasRole("USER")
//                .antMatchers("/api/auth/signup/**", "/api/auth/login/**", "/api").permitAll()
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/v2/api-docs",
//                        "/swagger-resources/**",
//                        "/swagger-ui/**",
//                        "/webjars/**",
//                        "favicon.ico"
//                        ).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/api/auth/login")
//                .defaultSuccessUrl("/", true)
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/drive/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/api/users/**", "/api/quiz/**", "/api/tips/**").hasAuthority("ADMIN")
                .antMatchers("/api/**").authenticated()
                .antMatchers(
                        HttpMethod.GET,
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/webjars/**",
                        "favicon.ico"
                        ).permitAll()
//                .anyRequest().authenticated()
//                .and()
                .anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).accessDeniedHandler(new CustomAccessDeniedHandler());
    }

}
