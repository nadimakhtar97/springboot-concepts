package com.nadim.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
@EnableWebSecurity will allow us to write configuration for spring
security. And since it is of type @Component it will be picked up
by springboot/application context
 */
@EnableWebSecurity
public class FooBarSecurityConfig extends WebSecurityConfigurerAdapter {

    // This is for authentication purpose
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*
        This is inMemory Authentication where usernames and passwords
        are hardcoded. This will be in main memory once application is started and
        deleted after terminating the application.
         */

        auth.inMemoryAuthentication()
                .withUser("nadim")
                .password("nadim_root")
                .roles("admin_role")
                .and()
                .withUser("lee")
                .password("lee_root")
                .roles("student_role");
    }


    // This is for authorization purpose
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        super.configure(http);  ---> do not call super class constructor

    /*
    This block of code is giving error in-spite of checking it thoroughly
    on various sources. I think there is a bug in current version.

    Error : Can't configure antMatchers after anyRequest

    Error resolved --> I was calling super class constructor [super.configure(http);] which was creating problem.
    do not call super class constructor. I don't know the reason why this happened.
     */

        http
                .httpBasic()  // this will remove html response you will get when request form postman and give json response
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin_role")
                .antMatchers("/student/**").hasAnyRole("admin_role","student_role")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    /*
    companies do not store raw user password due to security reasons. So they encode the raw password
    so that no one can understand the password.
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
