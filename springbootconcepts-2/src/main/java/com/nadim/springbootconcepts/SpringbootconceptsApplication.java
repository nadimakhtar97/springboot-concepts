package com.nadim.springbootconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootconceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootconceptsApplication.class, args);

		// This is our custom Application Context which co-exist with default Application Context.
		// In this project CustomBeanController is using default Application Context while
		// the main class is using the custom Application Context.
		// In general case we do not need to create custom Application Context.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(CustomBeanConfig.class);
		ctx.refresh();
		
		CustomBean bean = ctx.getBean(CustomBean.class);
		System.out.println(bean);
	}

}
