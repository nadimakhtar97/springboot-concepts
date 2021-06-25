package com.nadim.springbootconcepts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// @Configuration is used to register all the beans to  all application context present in
// the application be it default or custom.
@Configuration
public class CustomBeanConfig {


    @Bean    // The target for @Bean is function or any other annotation. So we can not apply it on a class.
//    @Scope("prototype")  // This will ensure that a new object of the bean is created for each request.
    public CustomBean customBean()
    {
        return new CustomBean("message","data");
    }



}
