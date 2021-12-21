//package com.borman.config;
//
//
//import com.borman.service.SpringDataUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Bean
////    public SpringDataUserDetailsService customUserDetailsService() {
////        return new SpringDataUserDetailsService();
////    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
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
//    }
//
////    @Override
////    public void configure(WebSecurity web) {
////        web
////                .ignoring()
////                .antMatchers(
////                        "/resources/**",
////                        "/css/**",
////                        "/js/**",
////                        "/images/**",
////                        "/views/**");
////    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth)
////            throws Exception {
////
////        auth
////                .userDetailsService(customUserDetailsService())
////                .passwordEncoder(passwordEncoder());
////    }
//}