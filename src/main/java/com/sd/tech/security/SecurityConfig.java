/*
 * package com.sd.tech.security;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * @Bean public UserDetailsService userDetailsService(PasswordEncoder encoder) {
 * UserDetails admin=User.withUsername("Balu")
 * .password(encoder.encode("Balu1")) .roles("admin"). build(); UserDetails
 * user=User.withUsername("Balu2") .password(encoder.encode("Balu1"))
 * .roles("user") .build();
 * 
 * //return (UserDetailsService) admin; return new
 * InMemoryUserDetailsManager(admin,user); }
 * 
 * @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
 * }
 * 
 * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
 * Exception { return http.csrf().disable() .authorizeHttpRequests()
 * .requestMatchers("/voter/save").permitAll() .and()
 * .authorizeHttpRequests().requestMatchers("/voter/**") .authenticated()
 * .and().formLogin() .and().build();
 * 
 * }
 * 
 * 
 * SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 * return http.authorizeHttpRequests( (authorize)->
 * authorize.requestMatchers("/", "/voter/save").permitAll()
 * .anyRequest().authenticated()) .formLogin((form) -> form .permitAll() )
 * .build();
 * 
 * 
 * 
 * }
 * 
 * }
 */