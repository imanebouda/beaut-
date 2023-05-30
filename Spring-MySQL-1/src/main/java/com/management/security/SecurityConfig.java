package com.management.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.formLogin().successForwardUrl("/productsList").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/createProduct").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/createParfum").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/createCategorie").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/showProduct").hasAnyRole("ADMIN","CACHIER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/showParfum").hasAnyRole("ADMIN","CACHIER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/updateProduct").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/updateParfum").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/deleteProduct").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/deleteParfum").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/productList").hasAnyRole("ADMIN","CACHIER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/parfumList").hasAnyRole("ADMIN","CACHIER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/categoriesList").hasAnyRole("ADMIN","CACHIER");






        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        return httpSecurity.build();
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password("{noop}123").roles("ADMIN","USER").build(),
        User.withUsername("imane").password("{noop}123").roles("CACHIER").build(),
        User.withUsername("ikrame").password("{noop}123").roles("USER").build()

        );
    }


}
