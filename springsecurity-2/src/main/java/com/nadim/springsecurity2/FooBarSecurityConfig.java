package com.nadim.springsecurity2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class FooBarSecurityConfig extends WebSecurityConfigurerAdapter {


    /*
        Two way to implement. Let abc be a user then
        1. we can give abc roles of admin_role,student_role both and authorize the api which students
           can access with student role hasRole("student") this way abc can access student pages as well
           as admin pages

        2. Or we can give abc only one role i.e admin_role and authorize the api which students can access with roles
        admin_role and student_role i.e hasAnyRole("student_role","admin_role").

        let's follow 1 one.
    */

    @Autowired
    FooBarUserDetailsService fooBarUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(fooBarUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin")     // NOTE : Role and Authority have meaning but they are different
                .antMatchers("/student/**").hasAnyAuthority("student", "admin")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
